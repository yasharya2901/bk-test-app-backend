package com.brahmakumaris.bktestapp.services.serviceInterface;

import com.brahmakumaris.bktestapp.dtos.BatchDTO.BatchCreationDTO;
import com.brahmakumaris.bktestapp.dtos.BatchDTO.BatchDTO;
import com.brahmakumaris.bktestapp.models.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchService{
    BatchDTO getBatchById(Long id);
    Batch getBatch(Long id);
    BatchDTO createBatch(BatchCreationDTO batch);
    void deleteBatch(Long id);
    BatchDTO findByBatchName(String batchName);
    List<BatchDTO> findAllBatches();
}
