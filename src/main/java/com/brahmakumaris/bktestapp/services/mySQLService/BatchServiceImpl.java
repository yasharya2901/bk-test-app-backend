package com.brahmakumaris.bktestapp.services.mySQLService;

import com.brahmakumaris.bktestapp.dtos.BatchDTO.BatchCreationDTO;
import com.brahmakumaris.bktestapp.dtos.BatchDTO.BatchDTO;
import com.brahmakumaris.bktestapp.models.Batch;
import com.brahmakumaris.bktestapp.models.Test.Test;
import com.brahmakumaris.bktestapp.models.User;
import com.brahmakumaris.bktestapp.repositories.BatchRepository;
import com.brahmakumaris.bktestapp.services.serviceInterface.BatchService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service

public class BatchServiceImpl implements BatchService {

    private final BatchRepository batchRepository;

    public BatchServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public BatchDTO getBatchById(Long id) {
        // TODO: Implement admin check
        Batch batch = batchRepository.findById(id).orElse(null);
        return convertBatchToBatchDTO(batch);
    }

    @Override
    public Batch getBatch(Long id) {
        return batchRepository.findById(id).orElse(null);
    }

    private BatchDTO convertBatchToBatchDTO(Batch batch) {
        BatchDTO batchDTO = new BatchDTO();
        batchDTO.setBatchId(batch.getBatchId());
        batchDTO.setBatchName(batch.getBatchName());
        List<Long> userIds = new LinkedList<>();
        List<User> users = batch.getUsers();
        if (users != null && !users.isEmpty()){
            for (int i = 0; i < users.size(); i++) {
                userIds.add(users.get(i).getUserId());
            }
        }

        List<Long> testIds = new LinkedList<>();
        List<Test> tests = batch.getTests();
        if (tests != null && !tests.isEmpty()){
            for (int i = 0; i < batch.getTests().size(); i++) {
                testIds.add(batch.getTests().get(i).getTestId());
            }
        }

        return batchDTO;
    }

    @Override
    public BatchDTO createBatch(BatchCreationDTO batchDTO) {
        // TODO: Implement admin check
        Batch batch = new Batch();
        batch.setBatchName(batchDTO.getBatchName());
        Batch batch1 = batchRepository.save(batch);
        return convertBatchToBatchDTO(batch1);
    }

    @Override
    public void deleteBatch(Long id) {
        // TODO: Implement admin check
        batchRepository.deleteById(id);
    }

    @Override
    public BatchDTO findByBatchName(String batchName) {
        Batch batch = batchRepository.findByBatchName(batchName);
        return convertBatchToBatchDTO(batch);
    }

    @Override
    public List<BatchDTO> findAllBatches() {
        List<Batch> batches = batchRepository.findAll();
        List<BatchDTO> batchDTOs = new LinkedList<>();
        for (Batch batch : batches) {
            batchDTOs.add(convertBatchToBatchDTO(batch));
        }
        return batchDTOs;
    }

}
