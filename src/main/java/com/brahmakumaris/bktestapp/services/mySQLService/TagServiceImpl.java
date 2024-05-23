package com.brahmakumaris.bktestapp.services.mySQLService;

import com.brahmakumaris.bktestapp.models.Section.Tag;
import com.brahmakumaris.bktestapp.repositories.TagRepository;
import com.brahmakumaris.bktestapp.services.serviceInterface.TagService;

import java.util.List;
import java.util.Optional;

public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }


    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag getTagById(Long id) {
        Optional<Tag> tag = tagRepository.findById(id);
        if (tag.isEmpty()) {
            // TODO: throw exception
        }
        return tag.get();
    }

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public List<Tag> findByTagName(String tagName) {
        return tagRepository.findByTagName(tagName);
    }
}
