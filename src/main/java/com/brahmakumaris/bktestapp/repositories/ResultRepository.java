package com.brahmakumaris.bktestapp.repositories;

import com.brahmakumaris.bktestapp.models.Result;
import com.brahmakumaris.bktestapp.models.Section.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    // Function that fetches marks for every question in a test
    @Query("SELECT r.marks FROM Result r JOIN r.marks m WHERE KEY(m).quesId = :questionId AND r.user.userId = :userId AND r.test.testId = :testId")
    Integer findMarksByQuestionAndUser(@Param("questionId") Long questionId, @Param("userId") Long userId, @Param("testId") Long testId);

    List<Result> findByTest_TestId(Long testId);
    List<Result> findByUser_UserId(Long userId);
}
