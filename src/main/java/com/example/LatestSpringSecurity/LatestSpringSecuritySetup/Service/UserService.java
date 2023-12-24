package com.example.LatestSpringSecurity.LatestSpringSecuritySetup.Service;

import com.example.LatestSpringSecurity.LatestSpringSecuritySetup.Model.User;
import com.example.LatestSpringSecurity.LatestSpringSecuritySetup.Repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//      Optional<User> userFromDB= Optional.ofNullable(userRepo.findByUserName(username));
//      if(!userFromDB.isPresent()){
//          throw new UsernameNotFoundException("Invalid User");
//      }
//      User user=userFromDB.get();

//return user;

        return userRepo.findByUserName(username);
    }

    public User signup(User user) {
       return userRepo.save(user);

    }
}
