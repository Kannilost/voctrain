package com.kanni.voctrain.repository;

import com.kanni.voctrain.domain.entities.UserVocabularyMarked;

import com.kanni.voctrain.domain.entities.UserVocabularyMarkedId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVocabularyMarkedRepository extends JpaRepository<UserVocabularyMarked, UserVocabularyMarkedId> {
}