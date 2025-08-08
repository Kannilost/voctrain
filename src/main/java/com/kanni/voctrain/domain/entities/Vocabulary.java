package com.kanni.voctrain.domain.entities;

import jakarta.persistence.*;



@Entity
@Table(name = "vocabulary")
public class Vocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vocabulary_id")
    private Integer vocabularyId;

    @Column(name = "word", nullable = false, length = 100)
    private String word;

    @Column(name = "language_name", nullable = false, length = 20)
    private String languageName;

    @Column(name = "part_of_speech", length = 20)
    private String partOfSpeech;

    @Column(name = "translation_word", nullable = false, length = 100)
    private String translationWord;

    @Column(name = "localization_id", nullable = false)
    private Integer localizationId;

    @ManyToOne
    @JoinColumn(name = "localization_id", updatable = false, insertable = false)
    private Localization localization;



    public Integer getVocabularyId() {
        return vocabularyId;
    }

    public String getWord() {
        return word;
    }

    public String getLanguageName() {
        return languageName;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public String getTranslationWord() {
        return translationWord;
    }

    public Integer getLocalizationId() {
        return localizationId;
    }

    @Transient
    private boolean marked = false;

    public void setMarked( boolean marked){
        this.marked = marked;
    }

    public boolean isMarked() {
        return marked;
    }
    // Getter & Setter
}