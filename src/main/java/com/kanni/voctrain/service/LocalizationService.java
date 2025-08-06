package com.kanni.voctrain.service;

import com.kanni.voctrain.domain.entities.Localization;

import java.util.List;

public interface LocalizationService {
    List<String> getAllLevelNames();
    List<Localization> findByLevelName(String levelName);
}
