package com.kanni.voctrain.web.rest;

import com.kanni.voctrain.config.VoctrainUser;
import com.kanni.voctrain.domain.entities.Localization;
import com.kanni.voctrain.domain.entities.UserVocabularyMarked;
import com.kanni.voctrain.domain.entities.Userinfo;
import com.kanni.voctrain.domain.entities.Vocabulary;
import com.kanni.voctrain.service.LocalizationService;
import com.kanni.voctrain.service.UserVocabularyMarkedService;
import com.kanni.voctrain.service.UserinfoService;
import com.kanni.voctrain.service.VocabularyService;
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

    public VocabularyController(LocalizationService localizationService,
                                VocabularyService vocabularyService,
                                UserinfoService userinfoService, UserVocabularyMarkedService userVocabularyMarkedService) {
        this.localizationService = localizationService;
        this.vocabularyService = vocabularyService;
        this.userinfoService = userinfoService;
        this.userVocabularyMarkedService = userVocabularyMarkedService;
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
}
