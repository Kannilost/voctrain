package com.kanni.voctrain.service;

import com.kanni.voctrain.config.VoctrainUser;
import com.kanni.voctrain.domain.entities.UserVocabularyLearned;
import com.kanni.voctrain.domain.entities.Vocabulary;

import java.util.List;

public interface UserVocabularyLearnedService{

    List<UserVocabularyLearned> findMyLearned();

    List<Vocabulary> setLearned(List<Vocabulary> vocabularies);

    Boolean setVocabularyLearned(int vocabularyId);

    List<Vocabulary> getMyLearnedVocabulary();

    Long countLearnedVocabulary();
}
