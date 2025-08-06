package com.kanni.voctrain.service;

import com.kanni.voctrain.domain.entities.Userinfo;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Optional;

public interface UserinfoService {

    Optional<Userinfo> findByUsername(String username);
}
