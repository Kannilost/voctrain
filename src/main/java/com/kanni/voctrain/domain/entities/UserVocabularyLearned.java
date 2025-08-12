package com.kanni.voctrain.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.sql.Timestamp;

@Entity
@Table(name = "user_vocabulary_learned")
@IdClass(UserVocabularyLearnedId.class)
public class UserVocabularyLearned {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Id
    @Column(name = "vocabulary_id")
    private Integer vocabularyId;

    @Column(name = "learned_date", nullable = false)
    private Timestamp learnedDate;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Userinfo user;

    @ManyToOne
    @JoinColumn(name = "vocabulary_id", insertable = false, updatable = false)
    private Vocabulary vocabulary;

    public Integer getUserId() {
        return userId;
    }

    public Integer getVocabularyId() {
        return vocabularyId;
    }

    public Timestamp getLearnedDate() {
        return learnedDate;
    }

    public void setLearnedDate(Timestamp learnedDate) {
        this.learnedDate = learnedDate;
    }

    public UserVocabularyLearned() {

    }

    public UserVocabularyLearned(Integer userId, Integer vocabularyId) {
        this.userId = userId;
        this.vocabularyId = vocabularyId;
        this.learnedDate = new Timestamp(System.currentTimeMillis());
    }

    // Getter & Setter
}