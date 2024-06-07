package com.brahmakumaris.bktestapp.dtos.TestDTO.Section;

import com.brahmakumaris.bktestapp.dtos.TestDTO.Option.OptionDTO;
import com.brahmakumaris.bktestapp.dtos.TestDTO.Question.QuestionDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SectionDTO {
    private String sectionName;
    private List<QuestionDTO> question;
}