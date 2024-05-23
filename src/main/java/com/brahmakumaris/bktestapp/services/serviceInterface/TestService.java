package com.brahmakumaris.bktestapp.services.serviceInterface;

import com.brahmakumaris.bktestapp.models.Test.Test;

import java.util.List;

public interface TestService {
    List<Test> getAllTests();
    Test getTestById(Long id);
    Test createTest(Test test);
    void deleteTest(Long id);
    List<Test> findByTestName(String testName);
}
