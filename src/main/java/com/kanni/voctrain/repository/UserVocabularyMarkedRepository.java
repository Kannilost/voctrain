package com.kanni.voctrain.repository;

import com.kanni.voctrain.domain.entities.UserVocabularyMarked;

import com.kanni.voctrain.domain.entities.UserVocabularyMarkedId;

import com.kanni.voctrain.domain.entities.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserVocabularyMarkedRepository extends JpaRepository<UserVocabularyMarked, UserVocabularyMarkedId> {
    List<UserVocabularyMarked> findByUserId(int userId);
    Optional<UserVocabularyMarked> findByUserIdAndVocabularyId(int userId, int vocabularyId);


    @Query("SELECT uvm.vocabulary FROM UserVocabularyMarked uvm WHERE uvm.userId = :userId")
    List<Vocabulary> findMarkedVocabularyByUserId(@Param("userId") Integer userId);
}