package io.github.tintinrevient.oauthserver.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.github.tintinrevient.oauthserver.model.User;
import io.github.tintinrevient.oauthserver.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.access.annotation.Secured;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private static final String ROLE_ADMIN = "ROLE_ADMIN";

    @Autowired
    private UserRepository userRepository;

    @Secured({ROLE_ADMIN})
    @RequestMapping(value="/user")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Secured({ROLE_ADMIN})
    @RequestMapping(value = "/user/{id}")
    public List<User> findById(@PathVariable(value = "id") int id){
        return userRepository.findById(id);
    }

}
