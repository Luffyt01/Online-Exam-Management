package com.project.online_exam_management.question_service.repositories;

import com.project.online_exam_management.question_service.entities.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
}
