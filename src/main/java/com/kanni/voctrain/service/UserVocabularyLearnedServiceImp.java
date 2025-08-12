package com.kanni.voctrain.service;

import com.kanni.voctrain.config.VoctrainUser;
import com.kanni.voctrain.domain.entities.UserVocabularyLearned;
import com.kanni.voctrain.domain.entities.Vocabulary;
import com.kanni.voctrain.repository.UserVocabularyLearnedRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UserVocabularyLearnedServiceImp implements UserVocabularyLearnedService {
    private final UserVocabularyLearnedRepository userVocabularyLearnedRepository;
    private final UserinfoService userinfoService;
    private final UserVocabularyMarkedService userVocabularyMarkedService;

    public UserVocabularyLearnedServiceImp(UserVocabularyLearnedRepository userVocabularyLearnedRepository,
                                           UserinfoService userinfoService,
                                           UserVocabularyMarkedService userVocabularyMarkedService) {
        this.userVocabularyLearnedRepository = userVocabularyLearnedRepository;
        this.userinfoService = userinfoService;
        this.userVocabularyMarkedService = userVocabularyMarkedService;
    }

    @Override
    public List<UserVocabularyLearned> findMyLearned() {
        VoctrainUser currentUser = userinfoService.getCurrentUser();
        return userVocabularyLearnedRepository.findByUserId(currentUser.getUserId());
    }

    @Override
    public List<Vocabulary> setLearned(List<Vocabulary> vocabularies) {
        VoctrainUser currentUser = userinfoService.getCurrentUser();
        for (Vocabulary vocabulary : vocabularies) {
            Optional<UserVocabularyLearned> userVocabularyLearnedOptional = userVocabularyLearnedRepository.findByUserIdAndVocabularyId(
                    currentUser.getUserId(), vocabulary.getVocabularyId());
            vocabulary.setLearned(userVocabularyLearnedOptional.isPresent());
        }
        return vocabularies;
    }

    @Override
    public Boolean setVocabularyLearned(int vocabularyId) {
        VoctrainUser currentUser = userinfoService.getCurrentUser();
        Optional<UserVocabularyLearned> userVocabularyLearnedOptional = userVocabularyLearnedRepository.findByUserIdAndVocabularyId(
                currentUser.getUserId(), vocabularyId);
        if (userVocabularyLearnedOptional.isPresent()) {
            UserVocabularyLearned userVocabularyLearned = userVocabularyLearnedOptional.get();
            userVocabularyLearned.setLearnedDate(new Timestamp(System.currentTimeMillis()));
            userVocabularyLearnedRepository.save(userVocabularyLearned);
            return true;
        } else  {
            userVocabularyLearnedRepository.save(new UserVocabularyLearned(currentUser.getUserId(), vocabularyId));
            return true;
        }
    }

    @Override
    public List<Vocabulary> getMyLearnedVocabulary() {
        VoctrainUser currentUser = userinfoService.getCurrentUser();
        Pageable top20 = PageRequest.of(0, 20);
        List<Vocabulary> oldestVocabularies = userVocabularyLearnedRepository.findTop20OldestVocabularyByUserId(currentUser.getUserId(), top20);
        for (Vocabulary vocabulary : oldestVocabularies) {
            vocabulary.setLearned(true);
        }
        return userVocabularyMarkedService.setMarked(oldestVocabularies);
    }

    public Long countLearnedVocabulary() {
        VoctrainUser currentUser = userinfoService.getCurrentUser();
        return userVocabularyLearnedRepository.countByUserId(currentUser.getUserId());
    }
}
