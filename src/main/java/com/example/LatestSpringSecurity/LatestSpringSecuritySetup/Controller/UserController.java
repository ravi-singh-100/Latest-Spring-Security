package com.example.LatestSpringSecurity.LatestSpringSecuritySetup.Controller;

import com.example.LatestSpringSecurity.LatestSpringSecuritySetup.Model.User;
import com.example.LatestSpringSecurity.LatestSpringSecuritySetup.Service.UserService;
import com.example.LatestSpringSecurity.LatestSpringSecuritySetup.Wrapper.UserWrapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Value("${user.authority.developer}")
    private String DEVELOPER_AUTHORITY;


    @Value("${user.authority.devops}")
    private String DEVOPS_AUTHORITY;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/signup")
    public String signup(@Valid @RequestBody  UserWrapper userWrapper){

        User user = User.builder()
                .userName(userWrapper.getUserName())
                .password(passwordEncoder.encode(userWrapper.getPassword()))
                .authorities(userWrapper.getIsDeveloper() ? DEVELOPER_AUTHORITY : DEVOPS_AUTHORITY).build();

//        userService.createUser(myUser);

        userService.signup(user);
        return "success";
    }
@GetMapping("/")
public String home(){
        return "Welcome";
}
    @GetMapping("/developer")
        public ResponseEntity<String>getDeveloper(){
            return new ResponseEntity<>("Hi Developer", HttpStatusCode.valueOf(200));
        }
        @GetMapping("/devops")
    public ResponseEntity<String>getDevops(){
        return new ResponseEntity<>("Hi Devops",HttpStatusCode.valueOf(200));
        }
    @GetMapping("/both")
    public ResponseEntity<String>getBoth(){
        return new ResponseEntity<>("Hi Both",HttpStatusCode.valueOf(200));
    }
}
