package com.kanni.voctrain.service;

import com.kanni.voctrain.domain.entities.Vocabulary;
import com.kanni.voctrain.repository.VocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocabularyServiceImp implements VocabularyService {
    @Autowired
    private VocabularyRepository vocabularyRepository;

    @Override
    public List<Vocabulary> findByLocalizationId(int localizationId) {
        return vocabularyRepository.findByLocalizationId(localizationId);
    }
}
