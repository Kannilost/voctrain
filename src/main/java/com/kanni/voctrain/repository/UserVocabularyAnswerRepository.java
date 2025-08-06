package com.kanni.voctrain.repository;

import com.kanni.voctrain.domain.entities.UserVocabularyAnswer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVocabularyAnswerRepository extends JpaRepository<UserVocabularyAnswer, Integer> {
}