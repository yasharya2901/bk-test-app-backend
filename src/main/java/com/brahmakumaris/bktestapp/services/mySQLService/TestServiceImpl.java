package com.brahmakumaris.bktestapp.services.mySQLService;

import com.brahmakumaris.bktestapp.models.Test.Test;
import com.brahmakumaris.bktestapp.repositories.TestRepository;
import com.brahmakumaris.bktestapp.services.serviceInterface.TestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    @Override
    public Test getTestById(Long id) {
        Optional<Test> test = testRepository.findById(id);
        if (test.isEmpty()) {
            // TODO: throw exception
        }
        return test.get();
    }

    @Override
    public Test createTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }

    @Override
    public List<Test> findByTestName(String testName) {
        return testRepository.findByTestName(testName);
    }
}
