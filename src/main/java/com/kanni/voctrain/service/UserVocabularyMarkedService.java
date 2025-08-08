package com.kanni.voctrain.service;

import com.kanni.voctrain.domain.entities.UserVocabularyMarked;
import com.kanni.voctrain.domain.entities.Vocabulary;

import java.util.List;

public interface UserVocabularyMarkedService {
    List<UserVocabularyMarked> findMyMarked();

    List<Vocabulary> setMarked(List<Vocabulary> vocabularies);

    Boolean setVocabularyMarked(int vocabularyId, boolean marked);

    List<Vocabulary> getMyMarkedVocabulary();
}
