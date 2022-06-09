package io.capstone.website_service.repository;

import io.capstone.website_service.entity.QA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QARepository extends JpaRepository<QA, Long> {
    List<QA> findAllByQuestion(String message);
}
