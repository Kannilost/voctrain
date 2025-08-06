package com.kanni.voctrain.repository;

import com.kanni.voctrain.domain.entities.Localization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalizationRepository extends JpaRepository<Localization, Integer> {
    // Optional: weitere Abfragen
    List<Localization> findByLevelName(String levelName);
}