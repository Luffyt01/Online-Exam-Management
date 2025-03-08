package com.project.online_exam_management.exam_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExamDTO {

    private Long id;
    private String title;
    private String description;
    private Integer duration;
    private LocalDateTime startTime;
    private Long createdBy;
}
