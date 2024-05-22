package com.brahmakumaris.bktestapp.services.mySQLService;

import com.brahmakumaris.bktestapp.models.Batch;
import com.brahmakumaris.bktestapp.repositories.BatchRepository;
import com.brahmakumaris.bktestapp.services.serviceInterface.BatchService;
import org.springframework.stereotype.Service;

@Service
public class BatchServiceImpl implements BatchService {

    private final BatchRepository batchRepository;

    public BatchServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public Batch getBatchById(Long id) {
        // TODO: Implement admin check
        return batchRepository.findById(id).orElse(null);
    }

    @Override
    public Batch createBatch(Batch batch) {
        // TODO: Implement admin check
        return batchRepository.save(batch);
    }

    @Override
    public void deleteBatch(Long id) {
        // TODO: Implement admin check
        batchRepository.deleteById(id);
    }

    @Override
    public Batch findByBatchName(String batchName) {
        return batchRepository.findByBatchName(batchName);
    }
}
