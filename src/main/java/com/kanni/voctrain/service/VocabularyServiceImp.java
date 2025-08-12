package com.kanni.voctrain.service;

import com.kanni.voctrain.config.VoctrainUser;
import com.kanni.voctrain.domain.entities.Vocabulary;
import com.kanni.voctrain.repository.VocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocabularyServiceImp implements VocabularyService {

    private final VocabularyRepository vocabularyRepository;
    private final UserVocabularyMarkedService vocabularyMarkedService;

    public VocabularyServiceImp(VocabularyRepository vocabularyRepository,
                                UserVocabularyMarkedService vocabularyMarkedService) {
        this.vocabularyRepository = vocabularyRepository;
        this.vocabularyMarkedService = vocabularyMarkedService;
    }

    @Override
    public List<Vocabulary> findByLocalizationId(int localizationId) {
        List<Vocabulary> vocabularies = vocabularyRepository.findByLocalizationId(localizationId);
        return vocabularyMarkedService.setMarked(vocabularies);
    }

    @Override
    public Long countVocabularies() {
        return vocabularyRepository.count();
    }
}
