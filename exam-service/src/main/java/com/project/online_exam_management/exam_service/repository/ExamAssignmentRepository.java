package com.project.online_exam_management.exam_service.repository;

import com.project.online_exam_management.exam_service.entities.ExamAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamAssignmentRepository extends JpaRepository<ExamAssignment, Long> {
}
