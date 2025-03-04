package com.project.dine_in_order_api.service;


import com.project.dine_in_order_api.dto.request.RegistrationRequest;
import com.project.dine_in_order_api.dto.request.UserRequest;
import com.project.dine_in_order_api.dto.response.UserResponse;
import com.project.dine_in_order_api.model.User;

public interface UserService {
    public UserResponse registerUser(RegistrationRequest user);

    UserResponse findUserById(long userId);

    UserResponse UpdateUserById(UserRequest userRequest, long userId);
}
