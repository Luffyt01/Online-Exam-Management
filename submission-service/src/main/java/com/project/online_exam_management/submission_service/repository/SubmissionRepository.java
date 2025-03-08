package com.project.online_exam_management.submission_service.repository;

import com.project.online_exam_management.submission_service.entities.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
