package com.federico.Ecommerce.services;

import com.federico.Ecommerce.dto.request.User.UserPatchDto;
import com.federico.Ecommerce.dto.request.User.UserPutDto;
import com.federico.Ecommerce.dto.request.User.UserRequestDto;
import com.federico.Ecommerce.dto.response.User.UserResponseDto;
import com.federico.Ecommerce.exception.ResourceNotFoundException;
import com.federico.Ecommerce.mapper.UserMapper;
import com.federico.Ecommerce.models.Entity.User;
import com.federico.Ecommerce.repositories.UserRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;

    public UserService(UserRepository repository, UserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }

    // POST
    public UserResponseDto createUser(UserRequestDto dto) {

        User userEntity = userMapper.toEntity(dto);

        User savedUser = repository.save(userEntity);

        return userMapper.toResponseDto(savedUser);
    }

    // PUT
    public UserResponseDto updateUser(Integer id, UserPutDto dto) {

        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        userMapper.updateUserFromDtoAll(dto, user);

        User updatedUser = repository.save(user);

        return userMapper.toResponseDto(updatedUser);
    }

    // PATCH
    public UserResponseDto patchUser(Integer id, UserPatchDto dto) {

        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        userMapper.updateUserFromDto(dto, user);

        User updatedUser = repository.save(user);

        return userMapper.toResponseDto(updatedUser);
    }

    // GET
    public UserResponseDto getUserById(Integer id) {

        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        return userMapper.toResponseDto(user);
    }

    public List<UserResponseDto> getAllUsers() {

        List<User> users = repository.findAll();

        if (users.isEmpty()) {
            throw new ResourceNotFoundException("Usuarios no encontrados");
        }

        List<UserResponseDto> responseDtos = new ArrayList<>();

        for (User user : users) {
            responseDtos.add(userMapper.toResponseDto(user));
        }

        return responseDtos;
    }

    // DELETE
    /*
    public void deleteUserById(Integer id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario no encontrado");
        }

        repository.deleteById(id);
    }
    */

    public UserResponseDto deleteUserById(Integer id) {

        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        UserResponseDto responseDto = userMapper.toResponseDto(user);
        
        repository.deleteById(id);

        return responseDto;
    }
}