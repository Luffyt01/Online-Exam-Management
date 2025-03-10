package com.project.online_exam_management.result_service.dto;

import com.project.online_exam_management.result_service.entities.enums.ExamStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {

    private Long id;
    private Long user_id;
    private Long exam_id;
    private Double score;
    private ExamStatus status;
}
