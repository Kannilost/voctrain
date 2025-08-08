package com.kanni.voctrain.service;

import com.kanni.voctrain.config.VoctrainUser;
import com.kanni.voctrain.domain.entities.Userinfo;


import java.util.Optional;

public interface UserinfoService {

    Optional<Userinfo> findByUsername(String username);
    VoctrainUser getCurrentUser();
}
