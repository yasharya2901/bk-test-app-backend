package com.brahmakumaris.bktestapp.services.mySQLService;

import com.brahmakumaris.bktestapp.models.Result;
import com.brahmakumaris.bktestapp.models.Section.Question;
import com.brahmakumaris.bktestapp.repositories.QuestionRepository;
import com.brahmakumaris.bktestapp.repositories.ResultRepository;
import com.brahmakumaris.bktestapp.repositories.TestRepository;
import com.brahmakumaris.bktestapp.services.serviceInterface.QuestionService;
import com.brahmakumaris.bktestapp.services.serviceInterface.ResultService;

import java.util.List;
import java.util.Optional;

public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;
    private final QuestionRepository questionRepository;
    private final TestRepository testRepository;

    public ResultServiceImpl(ResultRepository resultRepository, QuestionRepository questionRepository, TestRepository testRepository) {
        this.resultRepository = resultRepository;
        this.questionRepository = questionRepository;
        this.testRepository = testRepository;

    }

    @Override
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    @Override
    public Result getResultById(Long id) {
        Optional<Result> result = resultRepository.findById(id);
        if (result.isEmpty()) {
            // TODO: throw exception
        }
        return result.get();
    }

    @Override
    public Result createResult(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }

    @Override
    public List<Result> findByTestId(Long testId) {
        return resultRepository.findByTest_TestId(testId);
    }

    @Override
    public List<Result> findByUserId(Long userId) {
        return resultRepository.findByUser_UserId(userId);
    }

    @Override
    public Integer getScoreByTestIdAndUserId(Long testId, Long userId) {
        Integer obtainedMarks = 0;
        List<Question> questions = questionRepository.findBySection_Test_TestId(testId);
        for (Question question : questions) {
            Integer marks = resultRepository.findMarksByQuestionAndUser(question.getQuesId(), userId, testId);
            if (marks != null) {
                obtainedMarks += marks;
            }
        }
        return obtainedMarks;
    }

    @Override
    public Double getPercentageByTestIdAndUserId(Long testId, Long userId) {
        Double percentage = 0.0;
        Integer obtained_marks = getScoreByTestIdAndUserId(testId, userId);
        Integer total_marks = testRepository.findById(testId).get().getTotalMarks();
        percentage = (obtained_marks * 100.0) / total_marks;
        return percentage;
    }

}
