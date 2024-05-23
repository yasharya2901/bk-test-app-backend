package com.brahmakumaris.bktestapp.repositories;

import com.brahmakumaris.bktestapp.models.Test.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    List<Test> findByTestName(String testName);
}
