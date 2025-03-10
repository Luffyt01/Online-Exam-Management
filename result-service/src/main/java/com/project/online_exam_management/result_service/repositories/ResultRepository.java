package com.project.online_exam_management.result_service.repositories;

import com.project.online_exam_management.result_service.entities.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long > {
}
