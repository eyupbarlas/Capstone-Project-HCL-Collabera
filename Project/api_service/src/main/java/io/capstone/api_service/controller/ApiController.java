package io.capstone.api_service.controller;

import io.capstone.api_service.entity.Chat;
import io.capstone.api_service.entity.Message;
import io.capstone.api_service.service.UserService;
import io.capstone.api_service.utils.ChatInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private UserService userService;

    /**
     * Function to return chats with admin access
     * @return response of the chat and HTTP Status code 200
     */
    @ResponseBody
    @PostMapping("/api/admin/chats")
    public ResponseEntity<List<Chat>> chatsAdmin() {
        List<Chat> chatResponse = userService.getChats();
        return new ResponseEntity<>(chatResponse, HttpStatus.OK);
    }

    /**
     * Function to return messages with admin access
     * @param chatInput pre-made input request
     * @return response of the message and HTTP Status code 200
     */
    @ResponseBody
    @PostMapping("/api/admin/messages")
    public ResponseEntity<List<Message>> messagesAdmin(@RequestBody ChatInput chatInput) {
        List<Message> messageResponse = userService.getMessages(chatInput.getId());
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }

    /**
     * Function to return chats with user access
     * @return response of the chat and HTTP Status code 200
     */
    @ResponseBody
    @PostMapping("/api/user/chats")
    public ResponseEntity<List<Chat>> chatsUser() {
        List<Chat> chatResponse = userService.getChats();
        return new ResponseEntity<>(chatResponse, HttpStatus.OK);
    }

    /**
     * Function to return messages with user access
     * @param chatInput pre-made input request
     * @return response of the message and HTTP Status code 200
     */
    @ResponseBody
    @PostMapping("/api/user/messages")
    public ResponseEntity<List<Message>> messagesUser(@RequestBody ChatInput chatInput) {
        List<Message> messageResponse = userService.getMessages(chatInput.getId());
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }

}
