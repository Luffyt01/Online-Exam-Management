package com.project.online_exam_management.user_service.services;

import com.project.online_exam_management.user_service.dto.LoginDTO;
import com.project.online_exam_management.user_service.dto.LoginResponseDTO;
import com.project.online_exam_management.user_service.dto.SignUpDTO;
import com.project.online_exam_management.user_service.dto.UserDTO;
import com.project.online_exam_management.user_service.entities.User;
import com.project.online_exam_management.user_service.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;


    public UserDTO signUp(SignUpDTO signUpDTO){
        Optional<User> user = userService.getUserByEmail(signUpDTO.getEmail());

        if (user.isPresent()){
            throw new BadCredentialsException("User with email already exists "+signUpDTO.getEmail());
        }

        String pass = passwordEncoder.encode(signUpDTO.getPassword());
        User toBeCreatedUser = modelMapper.map(signUpDTO, User.class);
        toBeCreatedUser.setPassword(pass);
        User savedUser = userService.save(toBeCreatedUser);

        return modelMapper.map(savedUser, UserDTO.class);
    }

    public LoginResponseDTO login(LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
        );
        log.info("AUTHENTICATED: {}",authentication.isAuthenticated());
        log.info("USERNAME: {}", authentication.getName());

        User user = (User) authentication.getPrincipal();

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return new LoginResponseDTO(user.getId(), accessToken, refreshToken);
    }

    // TODO implement session management feature for managing the user sessions
//    public LoginResponseDTO loginResponseDTO(String refreshToken){
//        Long userId = jwtService.getUserIdFromToken(refreshToken);
//
//    }

}
