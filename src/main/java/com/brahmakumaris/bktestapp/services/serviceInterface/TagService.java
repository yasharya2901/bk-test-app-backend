package com.brahmakumaris.bktestapp.services.serviceInterface;

import com.brahmakumaris.bktestapp.models.Section.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAllTags();
    Tag getTagById(Long id);
    Tag createTag(Tag tag);
    void deleteTag(Long id);
    List<Tag> findByTagName(String tagName);
}
