package com.project.online_exam_management.user_service.dto;

import com.project.online_exam_management.user_service.entities.enums.Role;
import lombok.Data;

@Data
public class SignUpDTO {
    private String name;
    private String email;
    private String password;
    private Role role;
}
