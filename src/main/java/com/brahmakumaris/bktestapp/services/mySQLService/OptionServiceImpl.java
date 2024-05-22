package com.brahmakumaris.bktestapp.services.mySQLService;

import com.brahmakumaris.bktestapp.models.Section.Option;
import com.brahmakumaris.bktestapp.repositories.OptionRepository;
import com.brahmakumaris.bktestapp.services.serviceInterface.OptionService;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;

    public OptionServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }


    @Override
    public Option getOptionById(Long id) {
        Optional<Option> option = optionRepository.findById(id);
        if (option.isEmpty()) {
            // TODO: Implement exception handling
        }
        return option.get();
    }

    @Override
    public Option createOption(Option option) {
        // TODO: Implement admin check
        return optionRepository.save(option);
    }

    @Override
    public Option updateOption(Long id, Option option) {
        // TODO: Implement admin check
        return optionRepository.save(option);
    }

    @Override
    public void deleteOption(Long id) {
        // TODO: Implement admin check
        optionRepository.deleteById(id);
    }


}
