package com.project.dine_in_order_api.controller;

import com.project.dine_in_order_api.dto.request.RegistrationRequest;
import com.project.dine_in_order_api.dto.request.UserRequest;
import com.project.dine_in_order_api.dto.response.UserResponse;
import com.project.dine_in_order_api.model.User;
import com.project.dine_in_order_api.service.UserService;
import com.project.dine_in_order_api.util.ResponseBuilder;
import com.project.dine_in_order_api.util.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody  @Valid RegistrationRequest registrationRequest){
        UserResponse response=userService.registerUser(registrationRequest);
        return ResponseBuilder.success(HttpStatus.CREATED, "User Created",response);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable long userId){
        UserResponse response=userService.findUserById(userId);
        return ResponseBuilder.success(HttpStatus.OK,"User Found",response);
    }

    @PutMapping("/users/{userId}")
   public ResponseEntity<ResponseStructure<UserResponse>> UpdateUserById(@RequestBody UserRequest user,@PathVariable long userId){
         UserResponse response=userService.UpdateUserById(user,userId);
        return ResponseBuilder.success(HttpStatus.OK,"User Update",response);
    }


}
