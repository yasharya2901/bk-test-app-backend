package com.brahmakumaris.bktestapp.repositories;

import com.brahmakumaris.bktestapp.models.Section.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
}
