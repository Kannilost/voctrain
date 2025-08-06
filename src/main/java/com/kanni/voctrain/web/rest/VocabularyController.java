package com.kanni.voctrain.web.rest;

import com.kanni.voctrain.domain.entities.Localization;
import com.kanni.voctrain.domain.entities.Userinfo;
import com.kanni.voctrain.domain.entities.Vocabulary;
import com.kanni.voctrain.service.LocalizationService;
import com.kanni.voctrain.service.UserinfoService;
import com.kanni.voctrain.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class VocabularyController {

    private final LocalizationService localizationService;
    private final VocabularyService vocabularyService;
    private final UserinfoService userinfoService;

    public VocabularyController(LocalizationService localizationService,
                                VocabularyService vocabularyService,
                                UserinfoService userinfoService) {
        this.localizationService = localizationService;
        this.vocabularyService = vocabularyService;
        this.userinfoService = userinfoService;
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
}
