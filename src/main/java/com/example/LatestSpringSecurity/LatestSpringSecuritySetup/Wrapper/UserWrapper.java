package com.example.LatestSpringSecurity.LatestSpringSecuritySetup.Wrapper;

import com.example.LatestSpringSecurity.LatestSpringSecuritySetup.Model.User;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserWrapper {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
@NotNull
   private String userName;
@NotNull
    private String password;
private Boolean isDeveloper;
List<String>authorities;
//    private String authorities;

//   public User to(){
//       Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//       authorities.stream().forEach(authority ->
//               grantedAuthorities.add(new SimpleGrantedAuthority(authority)));
//       return User.builder().userName(userName).password(bCryptPasswordEncoder.encode(password)).authorities(authorities).build();
//   }
}
