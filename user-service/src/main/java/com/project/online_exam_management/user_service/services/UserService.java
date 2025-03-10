package com.project.online_exam_management.user_service.services;

import com.project.online_exam_management.user_service.dto.UserDTO;
import com.project.online_exam_management.user_service.entities.User;
import com.project.online_exam_management.user_service.exceptions.ResourceNotFoundException;
import com.project.online_exam_management.user_service.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public UserDTO getUserDtoById(Long userId){
        return modelMapper.map(getUserById(userId), UserDTO.class);
    }

    public User getUserById(Long userId) {
        log.info("Fetching user with id: "+userId);
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+userId));
    }

    public List<UserDTO> getAllUsers(){
        log.info("Fetching all users.");
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("User with email "+username+" not found"));
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }


    public User save(User newUser){
        return userRepository.save(newUser);
    }

}
