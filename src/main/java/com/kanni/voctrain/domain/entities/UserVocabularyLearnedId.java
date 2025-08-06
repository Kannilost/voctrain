package com.kanni.voctrain.domain.entities;

import java.io.Serializable;
import java.util.Objects;

public class UserVocabularyLearnedId implements Serializable {

    private Integer userId;
    private Integer vocabularyId;

    public UserVocabularyLearnedId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserVocabularyLearnedId)) return false;
        UserVocabularyLearnedId that = (UserVocabularyLearnedId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(vocabularyId, that.vocabularyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, vocabularyId);
    }
}