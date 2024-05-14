package com.brahmakumaris.bktestapp.repositories;

import com.brahmakumaris.bktestapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
