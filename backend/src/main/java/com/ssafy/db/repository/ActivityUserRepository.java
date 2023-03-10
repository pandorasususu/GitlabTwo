package com.ssafy.db.repository;

import com.ssafy.db.entity.ActivityUser;
import com.ssafy.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityUserRepository extends JpaRepository<ActivityUser, Long> {
}
