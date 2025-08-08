package com.kanni.voctrain.repository;

import com.kanni.voctrain.domain.entities.UserVocabularyLearned;

import com.kanni.voctrain.domain.entities.UserVocabularyLearnedId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVocabularyLearnedRepository extends JpaRepository<UserVocabularyLearned, UserVocabularyLearnedId> {
}