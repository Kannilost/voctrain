package com.kanni.voctrain.domain.entities;

import java.io.Serializable;
import java.util.Objects;

public class UserVocabularyMarkedId implements Serializable {

    private Integer userId;
    private Integer vocabularyId;

    public UserVocabularyMarkedId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserVocabularyMarkedId)) return false;
        UserVocabularyMarkedId that = (UserVocabularyMarkedId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(vocabularyId, that.vocabularyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, vocabularyId);
    }
}