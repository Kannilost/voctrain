package com.kanni.voctrain.service;

import com.kanni.voctrain.config.VoctrainUser;
import com.kanni.voctrain.domain.entities.Userinfo;
import com.kanni.voctrain.repository.UserinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserinfoServiceImp implements UserinfoService , UserDetailsService {

    @Autowired
    private UserinfoRepository userinfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Userinfo user = userinfoRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Benutzer nicht gefunden"));

        return new VoctrainUser(
                user.getUsername(),
                user.getPassword(), // ⚠️ Sollte mit BCrypt verschlüsselt sein!
                user.getUserId(),
                user.getEmail(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")) // Standardrolle – kannst du dynamisch machen
        );
    }

    @Override
    public Optional<Userinfo> findByUsername(String username) {
        return userinfoRepository.findByUsername(username);
    }
}