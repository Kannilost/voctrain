package com.kanni.voctrain.service;

import com.kanni.voctrain.domain.entities.Vocabulary;

import java.util.List;

public interface VocabularyService {
    List<Vocabulary> findByLocalizationId(int localizationId);

    Long countVocabularies();
}
