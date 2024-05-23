package com.brahmakumaris.bktestapp.services.serviceInterface;

import com.brahmakumaris.bktestapp.models.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchService{
    Batch getBatchById(Long id);
    Batch createBatch(Batch batch);
    void deleteBatch(Long id);
    Batch findByBatchName(String batchName);
    List<Batch> findAllBatches();
}
