package io.capstone.api_service.repository;

import io.capstone.api_service.entity.QA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QARepository extends JpaRepository<QA, Long> {
    List<QA> findAllByQuestion(String message);
}
