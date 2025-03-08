package com.project.online_exam_management.exam_service.dto;

import com.project.online_exam_management.exam_service.entities.Exam;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamAssignmentDTO {
    private Long id;
    private Long user_id;
    private Exam exam;
}
