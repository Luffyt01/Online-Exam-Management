package com.project.online_exam_management.question_service.repositories;

import com.project.online_exam_management.question_service.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
