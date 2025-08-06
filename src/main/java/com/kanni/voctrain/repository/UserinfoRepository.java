package com.kanni.voctrain.repository;

import com.kanni.voctrain.domain.entities.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserinfoRepository extends JpaRepository<Userinfo, Integer> {
    Optional<Userinfo> findByUsername(String username);
}
