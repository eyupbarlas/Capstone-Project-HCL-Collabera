package io.capstone.website_service.controller;

import io.capstone.website_service.entity.Chat;
import io.capstone.website_service.entity.Message;
import io.capstone.website_service.entity.MyUserDetails;
import io.capstone.website_service.entity.User;
import io.capstone.website_service.service.UserService;
import io.capstone.website_service.utils.ChatInput;
import io.capstone.website_service.utils.MessageBody;
import io.capstone.website_service.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BzzChatAPIController {
    @Autowired
    private UserService userService;


    /**
     * Connecting AJAX to API
     * @param messageBody instance
     * @return response and HTTP Status code
     */
    @ResponseBody
    @PostMapping("/api/hello")
    public ResponseEntity<Response> hello(@RequestBody MessageBody messageBody) {
        String user = "anonymousUser";

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal(); //? testing userdetails overrided
            user = myUserDetails.getUsername();
        }

        if (messageBody.getIndex() == 0) {
            Chat chat = userService.createChat(user);
            messageBody.setIndex(chat.getId());
        }
        userService.saveMessages(messageBody.getIndex(), user, messageBody.getMessage(), "user");

        String botResponse = bzzBot(messageBody.getMessage());

        Response response = new Response();
        response.setStatus("success");
        response.setData(botResponse);
        response.setChatId(messageBody.getIndex());

        userService.saveMessages(messageBody.getIndex(), user, botResponse, "bzzbot");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Bot that authenticates the user and gets the messages
     * @param message message sent by user
     * @return the response to that message
     */
    public String bzzBot(String message) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
            String[] userProperties = {"firstName", "lastName", "email"};
//            if(Arrays.stream(userProperties).toList().contains(message.toLowerCase())) {
            User user = userService.getUser(myUserDetails.getUsername());
            switch (message.toLowerCase()) {
                case "firstname" : return user.getFirstName();
                case "lastname" : return user.getLastName();
                case "email" : return user.getEmail();
            }
//            }
        }
        String result = userService.isInQA(message);
        return result;
    }

    /**
     * Getting all chats as a list
     * @return response and HTTP Status code
     */
    @PostMapping("/admin/chats")
    public ResponseEntity<List<Chat>> chats() {
        List<Chat> response = userService.getChats();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Getting all messages as a list
     * @param chatInput chat input response
     * @return response and HTTP Status code
     */
    @PostMapping("/admin/messages")
    public ResponseEntity<List<Message>> messages(@RequestBody ChatInput chatInput) {
        List<Message> response = userService.getMessages(chatInput.getId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
