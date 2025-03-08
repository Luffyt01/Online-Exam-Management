package com.project.online_exam_management.question_service.dto;

import com.project.online_exam_management.question_service.entities.Question;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class OptionDTO{
    private Long id;
    private Question question;
    private String optionText;
    private Boolean isCorrect;
}
