package com.ssafy.db.repository;

import com.ssafy.db.entity.MusicUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicUserRepository extends JpaRepository<MusicUser, Long> {
}
