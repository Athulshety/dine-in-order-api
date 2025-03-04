package com.project.dine_in_order_api.service.impl;

import com.project.dine_in_order_api.dto.request.RegistrationRequest;
import com.project.dine_in_order_api.dto.request.UserRequest;
import com.project.dine_in_order_api.dto.response.UserResponse;
import com.project.dine_in_order_api.enums.UserRole;
import com.project.dine_in_order_api.exception.UserNotFoundByIdException;
import com.project.dine_in_order_api.mapper.UserMapper;
import com.project.dine_in_order_api.model.Admin;
import com.project.dine_in_order_api.model.Staff;
import com.project.dine_in_order_api.model.User;
import com.project.dine_in_order_api.respository.UserRepository;
import com.project.dine_in_order_api.service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;
    private  final UserMapper userMapper;

    @Override
    public UserResponse registerUser(RegistrationRequest registrationRequest) {
        User user=this.createUserByRole(registrationRequest.getUserRole());
        userMapper.mapToUserEntity(registrationRequest,user);
        userRepository.save(user);

        return userMapper.mapToUserResponse(user);


    }
    private User createUserByRole(UserRole role){
        User user;
        switch (role){
            case ADMIN -> user=new Admin();
            case STAFF -> user=new Staff();
            default -> throw new RuntimeException("Failed to register user,invalid user");

        }
        return  user;
    }

    @Override
    public UserResponse findUserById(long userId) {
        User user= userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundByIdException("User not found by id"));
        return  userMapper.mapToUserResponse(user);
    }

    @Override
    public UserResponse UpdateUserById(UserRequest userRequest, long userId) {
        User exUser=userRepository.findById(userId)
                .orElseThrow(()->new UserNotFoundByIdException("User not found"));
        userMapper.mapToNewUserRequest(userRequest,exUser);
        userRepository.save(exUser);

        return userMapper.mapToUserResponse(exUser);

    }

}
