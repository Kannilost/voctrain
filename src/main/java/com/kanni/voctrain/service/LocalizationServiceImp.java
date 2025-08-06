package com.kanni.voctrain.service;

import com.kanni.voctrain.domain.entities.Localization;
import com.kanni.voctrain.repository.LocalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalizationServiceImp implements LocalizationService {

    @Autowired
    private LocalizationRepository localizationRepository;

    public List<String> getAllLevelNames() {
        List<Localization> localizations =  localizationRepository.findAll();

        return localizations.stream()
                .sorted(Comparator.comparing(Localization::getLocalizationId)) // Sortierung nach ID
                .map(Localization::getLevelName)
                .distinct()            // Duplikate vermeiden
                .collect(Collectors.toList());
    }

    @Override
    public List<Localization> findByLevelName(String levelName) {
        return localizationRepository.findByLevelName(levelName);
    }
}

// Stream<Localization> streamLocalization =   localizations.stream();
//        Stream<String> streamLevelName =   streamLocalization.map(Localization::getLevelName);
//        Stream<String> streamLevelNameDistinct = streamLevelName.distinct();