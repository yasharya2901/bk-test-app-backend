package com.brahmakumaris.bktestapp.controllers;

import com.brahmakumaris.bktestapp.models.Batch;
import com.brahmakumaris.bktestapp.services.serviceInterface.BatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test-app/v1/batch")
public class BatchController {
    private BatchService batchService;

    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    @GetMapping
    public List<Batch> getAllBatches() {
        return batchService.findAllBatches();
    }

    @GetMapping("/{id}")
    public Batch getBatchById(@PathVariable Long id) {
        return batchService.getBatchById(id);
    }

    @PostMapping
    public Batch createBatch(@RequestBody Batch batch) {
        return batchService.createBatch(batch);
    }

    @DeleteMapping("/{id}")
    public void deleteBatch(@PathVariable Long id) {
        batchService.deleteBatch(id);
    }
}
