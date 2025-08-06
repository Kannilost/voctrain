package com.kanni.voctrain.repository;

import com.kanni.voctrain.domain.entities.Vocabulary;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Integer> {
    List<Vocabulary> findByLocalizationId(int localizationId);
}
