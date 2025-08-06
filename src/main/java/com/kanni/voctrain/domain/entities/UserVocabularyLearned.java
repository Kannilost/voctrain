package com.kanni.voctrain.domain.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

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
    private LocalDate learnedDate;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Userinfo user;

    @ManyToOne
    @JoinColumn(name = "vocabulary_id", insertable = false, updatable = false)
    private Vocabulary vocabulary;

    // Getter & Setter
}