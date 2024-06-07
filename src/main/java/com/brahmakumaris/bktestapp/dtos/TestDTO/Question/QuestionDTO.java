package com.brahmakumaris.bktestapp.dtos.TestDTO.Question;

import com.brahmakumaris.bktestapp.dtos.TestDTO.Option.OptionDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionDTO {
    private String questionText;
    private String questionType;
    private int questionMarks;
    private List<OptionDTO> questionOptions;
}