package com.example.dtomapstruct.service;

import com.example.dtomapstruct.dto.UserDto;
import com.example.dtomapstruct.mapper.UserMapper;
import com.example.dtomapstruct.model.User;
import com.example.dtomapstruct.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  UserMapper userMapper;

//    public UserService(UserRepository userRepository, UserMapper userMapper) {
//        this.userRepository = userRepository;
//        this.userMapper = userMapper;
//    }

    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    public List<UserDto> getAllUsers() {
        return userMapper.toDTO(userRepository.findAll());
    }

//    public UserDto getUserById(Long id) throws Exception {
//        return userRepository.findById(id)
//                .map(userMapper::toDTO)
//                .orElseThrow(() -> new Exception("User not found"));
//    }
public UserDto getUserById(Long id) {
    User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    return userMapper.toDTO(user);
}

public UserDto getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return userMapper.toDTO(user);
}

    public UserDto updateUser(Long id, UserDto userDTO) throws Exception {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not found"));
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

