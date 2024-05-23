package com.brahmakumaris.bktestapp.services.serviceInterface;

import com.brahmakumaris.bktestapp.models.Result;

import java.util.List;

public interface ResultService {
    List<Result> getAllResults();
    Result getResultById(Long id);
    Result createResult(Result result);
    void deleteResult(Long id);
    List<Result> findByTestId(Long testId);
    List<Result> findByUserId(Long userId);
    Integer getScoreByTestIdAndUserId(Long testId, Long userId);
    Double getPercentageByTestIdAndUserId(Long testId, Long userId);
}
