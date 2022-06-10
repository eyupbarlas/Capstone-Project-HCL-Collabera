package io.capstone.api_service.repository;

import io.capstone.api_service.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Messages
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByConversation(Long id);
}