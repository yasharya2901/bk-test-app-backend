package com.brahmakumaris.bktestapp.dtos.BatchDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BatchDTO {
    private Long batchId;
    private String batchName;
    private List<Long> userIds;
    private List<Long> testIds;
}
