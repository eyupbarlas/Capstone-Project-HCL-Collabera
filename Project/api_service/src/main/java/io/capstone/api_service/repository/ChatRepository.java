package io.capstone.api_service.repository;

import io.capstone.api_service.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Chat History
 */
@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
}

