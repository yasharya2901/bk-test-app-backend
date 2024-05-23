package com.brahmakumaris.bktestapp.repositories;

import com.brahmakumaris.bktestapp.models.Section.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByTagName(String tagName);
}
