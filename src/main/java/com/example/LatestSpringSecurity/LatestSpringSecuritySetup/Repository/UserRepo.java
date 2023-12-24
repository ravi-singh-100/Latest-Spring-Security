package com.example.LatestSpringSecurity.LatestSpringSecuritySetup.Repository;

import com.example.LatestSpringSecurity.LatestSpringSecuritySetup.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
