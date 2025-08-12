package com.kanni.voctrain.repository;

import com.kanni.voctrain.domain.entities.UserVocabularyLearned;

import com.kanni.voctrain.domain.entities.UserVocabularyLearnedId;

import com.kanni.voctrain.domain.entities.Vocabulary;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface UserVocabularyLearnedRepository extends JpaRepository<UserVocabularyLearned, UserVocabularyLearnedId> {
    List<UserVocabularyLearned> findByUserId(int userId);
    Optional<UserVocabularyLearned> findByUserIdAndVocabularyId(int userId, int vocabularyId);


    @Query("SELECT uvm.vocabulary FROM UserVocabularyLearned uvm WHERE uvm.userId = :userId")
    List<Vocabulary> findLearnedVocabularyByUserId(@Param("userId") Integer userId);

    @Query("SELECT uvm.vocabulary FROM UserVocabularyLearned uvm WHERE uvm.userId = :userId ORDER BY uvm.learnedDate ASC")
    List<Vocabulary> findTop20OldestVocabularyByUserId(@Param("userId") Integer userId, Pageable pageable);

    long countByUserId(int userId);
}