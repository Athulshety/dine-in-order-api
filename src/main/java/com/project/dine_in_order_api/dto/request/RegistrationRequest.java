package com.project.dine_in_order_api.dto.request;

import com.project.dine_in_order_api.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
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
   @Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$",
            message = "Only Gmail accounts (@gmail.com) are allowed")
    private String email;
    @NotBlank(message = "Password can not be empty or white space")
    @NotEmpty(message = "Password can not be null")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,12}$",
            message = "Password must be 8 to 12 characters long and include at least one uppercase letter, one lowercase letter, one number, and one special character.")
    private String password;
    @NotBlank(message = "Phone number cannot be empty or whitespace")
    @NotEmpty(message = "Phone number cannot be null")
    @Pattern(
            regexp = "^[7-9]\\d{9}$",
            message = "Invalid phone number. It must be a 10-digit number starting with 7, 8, or 9."
    )
    private String phNo;
    private UserRole userRole;

}
