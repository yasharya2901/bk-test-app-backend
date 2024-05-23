package com.brahmakumaris.bktestapp.controllers;

import com.brahmakumaris.bktestapp.models.Section.Section;
import com.brahmakumaris.bktestapp.services.serviceInterface.SectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test-app/v1/section")
public class SectionController {
    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }


    @GetMapping
    public List<Section> getAllSections() {
        return sectionService.getAllSections();
    }

    @GetMapping("/{id}")
    public Section getSectionById(@PathVariable Long id) {
        return sectionService.getSectionById(id);
    }

    @PostMapping
    public Section createSection(@RequestBody Section section) {
        return sectionService.createSection(section);
    }


    @DeleteMapping("/{id}")
    public void deleteSection(@PathVariable Long id) {
        sectionService.deleteSection(id);
    }
}

