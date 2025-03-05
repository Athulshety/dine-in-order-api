package com.project.dine_in_order_api.controller;

import com.project.dine_in_order_api.dto.request.RegistrationRequest;
import com.project.dine_in_order_api.dto.request.UserRequest;
import com.project.dine_in_order_api.dto.response.UserResponse;
import com.project.dine_in_order_api.model.User;
import com.project.dine_in_order_api.service.UserService;
import com.project.dine_in_order_api.util.FieldErrorResponse;
import com.project.dine_in_order_api.util.ResponseBuilder;
import com.project.dine_in_order_api.util.ResponseStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${app.base-url}")
@Tag(name = "User Controller" ,description = "Collection API endPoint  dealing with user data")
public class UserController {
    private final UserService userService;


    @PostMapping("/register")
    @Operation(
            summary = "User Registration",
            description = """
        This API endpoint is used to register a new user. 
        The user must provide necessary details along with selecting one of the specified roles.
        """,
            responses = {
                    @ApiResponse(responseCode = "201", description = "User Created"),
                    @ApiResponse(responseCode = "400", description = "Invalid Input", content = {
                            @Content(schema = @Schema(implementation = FieldErrorResponse.class))
                    })
            })
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody  @Valid RegistrationRequest registrationRequest){
        UserResponse response=userService.registerUser(registrationRequest);
        return ResponseBuilder.success(HttpStatus.CREATED, "User Created",response);
    }
    @GetMapping("/user/{userId}")
    @Operation(
            summary = "User Registration",
            description = """
        This API endpoint is used to register a new user. 
        The user must provide necessary details along with selecting one of the specified roles.
        """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "User Found"),
                    @ApiResponse(responseCode = "400", description = "Invalid Input", content = {
                            @Content(schema = @Schema(implementation = FieldErrorResponse.class))
                    })
            })
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable long userId){
        UserResponse response=userService.findUserById(userId);
        return ResponseBuilder.success(HttpStatus.OK,"User Found",response);
    }

    @PutMapping("/users/{userId}")
    @Operation(
            summary = "User Registration",
            description = """
        This API endpoint is used to register a new user. 
        The user must provide necessary details along with selecting one of the specified roles.
        """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "User Updated"),
                    @ApiResponse(responseCode = "400", description = "Invalid Input", content = {
                            @Content(schema = @Schema(implementation = FieldErrorResponse.class))
                    })
            })
   public ResponseEntity<ResponseStructure<UserResponse>> UpdateUserById(@RequestBody UserRequest user,@PathVariable long userId){
         UserResponse response=userService.UpdateUserById(user,userId);
        return ResponseBuilder.success(HttpStatus.OK,"User Update",response);
    }


}
