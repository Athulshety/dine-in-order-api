package com.project.dine_in_order_api.mapper;

import com.project.dine_in_order_api.dto.request.RegistrationRequest;
import com.project.dine_in_order_api.dto.request.UserRequest;
import com.project.dine_in_order_api.dto.response.UserResponse;
import com.project.dine_in_order_api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

     UserResponse mapToUserResponse(User user) ;

     void mapToUserEntity(RegistrationRequest registrationRequest,@MappingTarget User user);

     void mapToNewUserRequest(UserRequest userRequest, @MappingTarget User exUser) ;


}
