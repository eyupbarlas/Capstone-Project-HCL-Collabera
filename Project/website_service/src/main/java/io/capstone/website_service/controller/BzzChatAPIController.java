package io.capstone.website_service.controller;

import io.capstone.website_service.entity.User;
import io.capstone.website_service.service.UserService;
import io.capstone.website_service.utils.MessageBody;
import io.capstone.website_service.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BzzChatAPIController {
    @Autowired
    private UserService userService;

//    @ResponseBody
//    @PostMapping("/api/hello")
//    public ResponseEntity<Response> hello(@RequestBody MessageBody messageBody) {
//        String user = "";
//    }


}
