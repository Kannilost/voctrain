package com.kanni.voctrain.web.rest;

import com.kanni.voctrain.config.VoctrainUser;
import com.kanni.voctrain.domain.entities.*;
import com.kanni.voctrain.service.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class VocabularyController {

    private final LocalizationService localizationService;
    private final VocabularyService vocabularyService;
    private final UserinfoService userinfoService;
    private final UserVocabularyMarkedService userVocabularyMarkedService;
    private final UserVocabularyLearnedService userVocabularyLearnedService;

    public VocabularyController(LocalizationService localizationService,
                                VocabularyService vocabularyService,
                                UserinfoService userinfoService, UserVocabularyMarkedService userVocabularyMarkedService,
                                UserVocabularyLearnedService userVocabularyLearnedService) {
        this.localizationService = localizationService;
        this.vocabularyService = vocabularyService;
        this.userinfoService = userinfoService;
        this.userVocabularyMarkedService = userVocabularyMarkedService;
        this.userVocabularyLearnedService = userVocabularyLearnedService;
    }

    @GetMapping("/levels")
    public List<String> getAllLevels() {
        return localizationService.getAllLevelNames();
    }

    @GetMapping("/localizations/{levelName}")
    public List<Localization> getAllLocalizations(@PathVariable String levelName) {
        return localizationService.findByLevelName(levelName);
    }

    @GetMapping("/vocabularies/{localizationId}")
    public List<Vocabulary> getAllVocabularies(@PathVariable int localizationId) {
        return vocabularyService.findByLocalizationId(localizationId);
    }

    @GetMapping("/me")
    public Optional<Userinfo> currentUser(@AuthenticationPrincipal UserDetails userDetails) {
        return userinfoService.findByUsername(userDetails.getUsername());
    }

    @GetMapping("/set-vocabulary-marked/{vocabularyId}/{marked}")
    public Boolean setVocabularyMarked(@PathVariable int vocabularyId, @PathVariable boolean marked) {
        return userVocabularyMarkedService.setVocabularyMarked(vocabularyId, marked);
    }

    @GetMapping("/marked-vocabularies")
    public List<UserVocabularyMarked> getAllMarkedVocabularies() {
        return userVocabularyMarkedService.findMyMarked();
    }

    @GetMapping("/getCurrentUser")
    public Optional<VoctrainUser> getCurrentUser() {
        return Optional.of(userinfoService.getCurrentUser());
    }

    @GetMapping("/get-marked-vocabularies")
    public List<Vocabulary> listAllMarkedVocabularies() {
        return userVocabularyMarkedService.getMyMarkedVocabulary();
    }

    @GetMapping("/set-vocabulary-learned/{vocabularyId}")
    public Boolean setVocabularyLearned(@PathVariable int vocabularyId) {
        return userVocabularyLearnedService.setVocabularyLearned(vocabularyId);
    }

    @GetMapping("/get-learned-vocabularies")
    public List<Vocabulary> listAllLearnedVocabularies() {
        return userVocabularyLearnedService.getMyLearnedVocabulary();
    }

    @GetMapping("/learned-vocabularies")
    public List<UserVocabularyLearned> getAllLearnedVocabularies() {
        return userVocabularyLearnedService.findMyLearned();
    }

    @GetMapping("/get-learned-percent")
    public int getLearnedPercent(){
        int total = vocabularyService.countVocabularies().intValue();
        int learned = userVocabularyLearnedService.countLearnedVocabulary().intValue();

        if (total == 0) {
            return 0; // Vermeide Division durch 0
        }
        return (learned * 100) / total; // Prozentwert als Ganzzahl
    }
}
