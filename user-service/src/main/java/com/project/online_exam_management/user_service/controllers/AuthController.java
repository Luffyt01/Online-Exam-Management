package com.project.online_exam_management.user_service.controllers;

import com.project.online_exam_management.user_service.dto.LoginDTO;
import com.project.online_exam_management.user_service.dto.LoginResponseDTO;
import com.project.online_exam_management.user_service.dto.SignUpDTO;
import com.project.online_exam_management.user_service.dto.UserDTO;
import com.project.online_exam_management.user_service.services.AuthService;
import com.project.online_exam_management.user_service.services.JwtService;
import com.project.online_exam_management.user_service.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {


    private final AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody SignUpDTO signUpDTO){
        UserDTO userDTO = authService.signUp(signUpDTO);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDTO){
        LoginResponseDTO loginResponseDTO = authService.login(loginDTO);
        return ResponseEntity.ok(loginResponseDTO);
    }

}
