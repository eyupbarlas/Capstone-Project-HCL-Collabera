package io.capstone.website_service.service;

import io.capstone.website_service.entity.Chat;
import io.capstone.website_service.entity.Message;
import io.capstone.website_service.entity.QA;
import io.capstone.website_service.entity.User;
import io.capstone.website_service.repository.ChatRepository;
import io.capstone.website_service.repository.MessageRepository;
import io.capstone.website_service.repository.QARepository;
import io.capstone.website_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private QARepository qaRepository;

    public Chat createChat(String anonymous) {
        Chat chat = new Chat();
        chat.setUser(anonymous);
        chat.setStartTime(new Date());
        chatRepository.save(chat);

        return chat;
    }

    public void saveMessages(Long index, String user, String msg, String owner) {
        Message message = new Message();
        message.setMessage(msg);
        message.setUser(user);
        message.setOwner(owner);
        message.setConversation(index);
        message.setDateTime( new Date());

        messageRepository.save(message);
    }

    public String isInQA(String message) {
        List<QA> qnAList =  qaRepository.findAllByQuestion(message);

        if(qnAList.isEmpty()){
            return "Can't help rn, try something new";
        }
        else {
            return qnAList.get(0).getAnswer();
        }
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    public List<Chat> getChats() {
        return chatRepository.findAll();
    }

    public List<Message> getMessages(Long id) {
        return messageRepository.findAllByConversation(id);
    }
}
