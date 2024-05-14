package com.brahmakumaris.bktestapp.repositories;

import com.brahmakumaris.bktestapp.models.Section.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
}
