package com.brahmakumaris.bktestapp.repositories;

import com.brahmakumaris.bktestapp.models.Section.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findBySectionId(Long sectionId);
    List<Question> findByQuesType(String quesType);
    List<Question> findByTags_TagId(Long tagId);  // Added method to find questions by tag ID
    List<Question> findByTags_TagName(String tagName);
}
