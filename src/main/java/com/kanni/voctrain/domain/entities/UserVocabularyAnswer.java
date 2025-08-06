package com.kanni.voctrain.domain.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "create_table_user_vocabulary_answers")
public class UserVocabularyAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Integer answerId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Userinfo user;

    @ManyToOne
    @JoinColumn(name = "vocabulary_id", nullable = false)
    private Vocabulary vocabulary;

    @Column(name = "is_correct")
    private Integer isCorrect;

    @Column(name = "attempts")
    private Integer attempts;

    @Column(name = "answer_date", insertable = false, updatable = false)
    private Timestamp answerDate;

    // Getter & Setter
}