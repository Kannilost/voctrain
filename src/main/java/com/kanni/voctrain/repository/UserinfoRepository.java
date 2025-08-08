package com.kanni.voctrain.repository;

import com.kanni.voctrain.domain.entities.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserinfoRepository extends JpaRepository<Userinfo, Integer> {
    Optional<Userinfo> findByUsername(String username);
}
