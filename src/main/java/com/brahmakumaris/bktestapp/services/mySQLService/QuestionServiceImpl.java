package com.brahmakumaris.bktestapp.services.mySQLService;

import com.brahmakumaris.bktestapp.models.Section.Question;
import com.brahmakumaris.bktestapp.repositories.QuestionRepository;
import com.brahmakumaris.bktestapp.services.serviceInterface.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isEmpty()) {
            // TODO: throw exception
        }
        return question.get();
    }

    @Override
    public Question createQuestion(Question question) {
        // TODO: Implement admin check
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long id) {
        // TODO: Implement admin check
        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> findBySectionId(Long sectionId) {
        return questionRepository.findBySection_SectionId(sectionId);
    }

//    @Override
//    public List<Question> findByQuesType(String quesType) {
//        return questionRepository.findByQuesType(quesType);
//    }
//
//    @Override
//    public List<Question> findByTagId(Long tagId) {
//        return questionRepository.findByTags_TagId(tagId);
//    }
//
//    @Override
//    public List<Question> findByTagName(String tagName) {
//        return questionRepository.findByTags_TagName(tagName);
//    }

//    @Override
//    public List<Question> findByTestId(Long testId) {
//        return questionRepository.findByTests_TestId(testId);
//    }

}
