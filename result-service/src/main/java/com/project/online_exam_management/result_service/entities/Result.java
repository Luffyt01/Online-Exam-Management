package com.project.online_exam_management.result_service.entities;

import com.project.online_exam_management.result_service.entities.enums.ExamStatus;
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
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private Long exam_id;
    private Double score;

    @Enumerated(EnumType.STRING)
    private ExamStatus status;
}
