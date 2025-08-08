package com.kanni.voctrain.service;


import com.kanni.voctrain.config.VoctrainUser;
import com.kanni.voctrain.domain.entities.UserVocabularyMarked;
import com.kanni.voctrain.domain.entities.Vocabulary;
import com.kanni.voctrain.repository.UserVocabularyMarkedRepository;
import com.kanni.voctrain.repository.VocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserVocabularyMarkedServiceImp implements UserVocabularyMarkedService {

    private final UserVocabularyMarkedRepository userVocabularyMarkedRepository;
    private final UserinfoService userinfoService;

    public UserVocabularyMarkedServiceImp(UserVocabularyMarkedRepository userVocabularyMarkedRepository,
                                          UserinfoService userinfoService) {
        this.userVocabularyMarkedRepository = userVocabularyMarkedRepository;
        this.userinfoService = userinfoService;
    }

    @Override
    public List<UserVocabularyMarked> findMyMarked() {
        VoctrainUser currentUser = userinfoService.getCurrentUser();
        return userVocabularyMarkedRepository.findByUserId(currentUser.getUserId());
    }

    @Override
    public List<Vocabulary> setMarked(List<Vocabulary> vocabularies) {
        VoctrainUser currentUser = userinfoService.getCurrentUser();
        for (Vocabulary vocabulary : vocabularies) {
            Optional<UserVocabularyMarked> userVocabularyMarkedOptional = userVocabularyMarkedRepository.findByUserIdAndVocabularyId(
                    currentUser.getUserId(), vocabulary.getVocabularyId());
            vocabulary.setMarked(userVocabularyMarkedOptional.isPresent());
        }
        return vocabularies;
    }

    @Override
    public Boolean setVocabularyMarked(int vocabularyId, boolean marked) {
        VoctrainUser currentUser = userinfoService.getCurrentUser();
        Optional<UserVocabularyMarked> userVocabularyMarkedOptional = userVocabularyMarkedRepository.findByUserIdAndVocabularyId(
                currentUser.getUserId(), vocabularyId);
        if (userVocabularyMarkedOptional.isPresent() && marked) {
            return true;
        } else if (userVocabularyMarkedOptional.isPresent() && !marked) {
            userVocabularyMarkedRepository.delete(userVocabularyMarkedOptional.get());
            return true;
        } else if (userVocabularyMarkedOptional.isEmpty() && marked) {
            userVocabularyMarkedRepository.save(new UserVocabularyMarked(currentUser.getUserId(), vocabularyId));
            return true;
        } else {
            return true;
        }
    }

    @Override
    public List<Vocabulary> getMyMarkedVocabulary() {
        VoctrainUser currentUser = userinfoService.getCurrentUser();
        List<Vocabulary> vocabularies =userVocabularyMarkedRepository.findMarkedVocabularyByUserId(currentUser.getUserId());
        for (Vocabulary vocabulary : vocabularies) {
            vocabulary.setMarked(true);
        }
        return vocabularies;
    }
}