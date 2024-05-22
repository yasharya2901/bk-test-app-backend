package com.brahmakumaris.bktestapp.services.serviceInterface;

import com.brahmakumaris.bktestapp.models.Section.Section;

import java.util.List;

public interface SectionService {
    List<Section> getAllSections();
    Section getSectionById(Long id);
    Section createSection(Section section);
    void deleteSection(Long id);
    List<Section> findByTestId(Long testId);
}
