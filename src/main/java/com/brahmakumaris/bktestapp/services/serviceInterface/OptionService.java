package com.brahmakumaris.bktestapp.services.serviceInterface;

import com.brahmakumaris.bktestapp.models.Section.Option;

import java.util.List;
import java.util.Optional;

public interface OptionService {
    Option getOptionById(Long id);
    Option createOption(Option option);
    Option updateOption(Long id, Option option);
    void deleteOption(Long id);
}
