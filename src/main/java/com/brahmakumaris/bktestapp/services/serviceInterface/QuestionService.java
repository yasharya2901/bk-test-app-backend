package com.brahmakumaris.bktestapp.services.serviceInterface;

import com.brahmakumaris.bktestapp.models.Section.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> getAllQuestions();
    Question getQuestionById(Long id);
    Question createQuestion(Question question);
    void deleteQuestion(Long id);
    List<Question> findBySectionId(Long sectionId);
    List<Question> findByQuesType(String quesType);
    List<Question> findByTagId(Long tagId);  // Added method to find questions by tag ID
    List<Question> findByTagName(String tagName);  // Added method to find questions by tag name
}
