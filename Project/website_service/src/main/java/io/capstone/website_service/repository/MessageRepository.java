package io.capstone.website_service.repository;

import io.capstone.website_service.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByConversation(Long id);
}
