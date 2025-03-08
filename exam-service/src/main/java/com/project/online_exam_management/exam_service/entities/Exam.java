package com.project.online_exam_management.exam_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exam {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Integer duration;
    private LocalDateTime startTime;

    private Long createdBy;
}
