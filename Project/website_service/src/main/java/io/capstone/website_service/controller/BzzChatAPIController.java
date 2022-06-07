package io.capstone.website_service.controller;

import io.capstone.website_service.entity.User;
import io.capstone.website_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BzzChatAPIController {
    @Autowired
    private UserService userService;


}
