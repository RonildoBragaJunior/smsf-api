package com.squirrel.smsfapi.controller;

import com.squirrel.smsfapi.exception.ResourceNotFoundException;
import com.squirrel.smsfapi.model.User;
import com.squirrel.smsfapi.repository.UserRepository;
import com.squirrel.smsfapi.security.CurrentUser;
import com.squirrel.smsfapi.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
