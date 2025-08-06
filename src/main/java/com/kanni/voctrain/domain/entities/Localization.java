package com.kanni.voctrain.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "localization")
public class Localization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "localization_id")
    private Integer localizationId;

    @Column(name = "level_name", nullable = false, length = 20)
    private String levelName;

    @Column(name = "unit_name", nullable = false, length = 20)
    private String unitName;


    // Getter & Setter
    public String getLevelName() {
        return levelName;
    }

    public String getUnitName() {
        return unitName;
    }

    public Integer getLocalizationId() {
        return localizationId;
    }

}