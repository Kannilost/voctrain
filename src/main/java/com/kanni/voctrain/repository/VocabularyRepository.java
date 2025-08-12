package com.kanni.voctrain.repository;

import com.kanni.voctrain.domain.entities.Vocabulary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VocabularyRepository extends JpaRepository<Vocabulary, Integer> {
    List<Vocabulary> findByLocalizationId(int localizationId);


}
