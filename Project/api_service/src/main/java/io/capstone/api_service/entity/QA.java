package io.capstone.api_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Questions and Answers Entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class QA {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String question;
    private String answer;
    private String keywords;
    private String category;
}