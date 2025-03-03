package com.project.dine_in_order_api.dto.request;

import com.project.dine_in_order_api.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class RegistrationRequest {
    @NotBlank(message = "username can not be empty or white space")
    @NotEmpty(message = "Username can't be null ")//cobination of notnull and Notblank
    @Pattern(regexp = "^[a-zA-Z0-9_]+$",message = "User name can only contain alphabetes,number,underscore")
    private String userName;
    @NotBlank(message = "Email can not be empty or white space")
    @NotEmpty(message = "Email can not be null")
    private String email;
    private String password;
    private String phNo;
    private UserRole userRole;

}
