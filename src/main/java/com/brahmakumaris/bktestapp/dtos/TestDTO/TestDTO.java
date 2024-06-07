package com.brahmakumaris.bktestapp.dtos.TestDTO;

import com.brahmakumaris.bktestapp.dtos.TestDTO.Section.SectionDTO;
import com.brahmakumaris.bktestapp.models.Batch;
import com.brahmakumaris.bktestapp.models.Section.Section;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TestDTO {
    private String test;
    private Date testDate;
    private int timeLimit;
    private List<SectionDTO> section;
}
