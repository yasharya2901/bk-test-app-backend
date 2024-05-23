package com.brahmakumaris.bktestapp.services.mySQLService;

import com.brahmakumaris.bktestapp.models.Section.Section;
import com.brahmakumaris.bktestapp.repositories.SectionRepository;
import com.brahmakumaris.bktestapp.services.serviceInterface.SectionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;

    public SectionServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    @Override
    public Section getSectionById(Long id) {
        Optional<Section> section = sectionRepository.findById(id);
        if (section.isEmpty()) {
            // TODO: throw exception
        }
        return section.get();
    }

    @Override
    public Section createSection(Section section) {
        // TODO: Implement admin check
        return sectionRepository.save(section);
    }

    @Override
    public void deleteSection(Long id) {
        // TODO: Implement admin check
        sectionRepository.deleteById(id);
    }

    @Override
    public List<Section> findByTestId(Long testId) {
        return sectionRepository.findByTest_TestId(testId);
    }
}
