package io.capstone.api_service.service;

import io.capstone.api_service.entity.Chat;
import io.capstone.api_service.entity.Message;
import io.capstone.api_service.entity.QA;
import io.capstone.api_service.entity.User;
import io.capstone.api_service.repository.ChatRepository;
import io.capstone.api_service.repository.MessageRepository;
import io.capstone.api_service.repository.QARepository;
import io.capstone.api_service.repository.UserRepository;
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

    /**
     * Saving new chat to database
     * @param anonymous username
     * @return chat itself
     */
    public Chat createChat(String anonymous) {
        Chat chat = new Chat();
        chat.setUser(anonymous);
        chat.setStartTime(new Date());
        chatRepository.save(chat);

        return chat;
    }


    /**
     * Saving messages to the database
     * @param index message index
     * @param user user connected
     * @param msg message itself
     * @param owner user who sends the messages
     */
    public void saveMessages(Long index, String user, String msg, String owner) {
        Message message = new Message();
        message.setMessage(msg);
        message.setUser(user);
        message.setOwner(owner);
        message.setConversation(index);
        message.setDateTime( new Date());

        messageRepository.save(message);
    }

    /**
     * Checking if question and its answer is in DB
     * @param message message sent by user
     * @return if there's no answer for that question, error message. If there is, return the answer for it
     */
    public String isInQA(String message) {
        List<QA> qnAList =  qaRepository.findAllByQuestion(message);

        if(qnAList.isEmpty()){
            return "Can't help rn, try something new";
        }
        else {
            return qnAList.get(0).getAnswer();
        }
    }


    /**
     * Saving user to the DB
     * @param user user instance
     */
    public void save(User user) {
        userRepository.save(user);
    }

    /**
     * Getting all users from DB
     * @return all users in database
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Getting a specific user from DB
     * @param email user's saved email
     * @return finding user by email
     */
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Getting all chats made from DB
     * @return all chats
     */
    public List<Chat> getChats() {
        return chatRepository.findAll();
    }

    /**
     * Getting all messages via message id's from DB
     * @param id message id
     * @return all messages
     */
    public List<Message> getMessages(Long id) {
        return messageRepository.findAllByConversation(id);
    }
}
