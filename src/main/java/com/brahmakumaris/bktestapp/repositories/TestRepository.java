package com.brahmakumaris.bktestapp.repositories;

import com.brahmakumaris.bktestapp.models.Test.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}
