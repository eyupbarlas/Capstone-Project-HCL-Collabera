package io.capstone.website_service.repository;

import io.capstone.website_service.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Chat History
 */
@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
}
