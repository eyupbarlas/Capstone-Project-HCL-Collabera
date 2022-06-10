package io.capstone.api_service.repository;

import io.capstone.api_service.entity.QA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Questions and Answers
 */
@Repository
public interface QARepository extends JpaRepository<QA, Long> {
    List<QA> findAllByQuestion(String message);
}

