package com.project.dine_in_order_api.mapper;

import com.project.dine_in_order_api.dto.request.RegistrationRequest;
import com.project.dine_in_order_api.dto.response.UserResponse;
import com.project.dine_in_order_api.model.User;

public class UserMapper {

    public UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .userRole(user.getUserRole())
                .createdAt(user.getCreatedAt())
                .lastModifiedAt(user.getLastModifiedAt())
                .build();
    }

    public void mapToUserEntity(RegistrationRequest registrationRequest, User user){
        user.setUserName(registrationRequest.getUserName());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(registrationRequest.getPassword());
        user.setPhNo(registrationRequest.getPhNo());
        user.setUserRole(registrationRequest.getUserRole());
    }

    public void mapToNewUserRequest(RegistrationRequest userRequest, User exUser) {
        exUser.setUserName(userRequest.getUserName());
        exUser.setEmail(userRequest.getEmail());
        exUser.setPhNo(userRequest.getPhNo());

    }
}
