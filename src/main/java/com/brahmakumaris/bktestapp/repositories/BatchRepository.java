package com.brahmakumaris.bktestapp.repositories;

import com.brahmakumaris.bktestapp.models.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
    Batch findByBatchName(String batchName);
}
