package com.project.online_exam_management.question_service.entities;

import com.project.online_exam_management.question_service.entities.enums.QuestionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long exam_id;

    private String content;

    @Enumerated(EnumType.STRING)
    private QuestionType type;
}
