package com.kanni.voctrain.domain.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_vocabulary_marked")
@IdClass(UserVocabularyMarkedId.class)
public class UserVocabularyMarked {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Id
    @Column(name = "vocabulary_id")
    private Integer vocabularyId;

    @Column(name = "marked_date", nullable = false)
    private LocalDate markedDate;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Userinfo user;

    @ManyToOne
    @JoinColumn(name = "vocabulary_id", insertable = false, updatable = false)
    private Vocabulary vocabulary;

    // Getter & Setter
}