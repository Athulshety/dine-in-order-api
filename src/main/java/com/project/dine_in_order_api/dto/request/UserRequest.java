package com.project.dine_in_order_api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    @NotBlank(message = "username can not be empty or white space")
    @NotEmpty(message = "Username can't be null ")//cobination of notnull and Notblank
    @Pattern(regexp = "^[a-zA-Z0-9_]+$",message = "User name can only contain alphabetes,number,underscore")
    private String userName;

    @NotBlank(message = "Email can not be empty or white space")
    @NotEmpty(message = "Email can not be null")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$",
            message = "Only Gmail accounts (@gmail.com) are allowed")
    private  String email;

    @NotBlank(message = "Phone number cannot be empty or whitespace")
    @NotEmpty(message = "Phone number cannot be null")
    @Pattern(
            regexp = "^[7-9]\\d{9}$",
            message = "Invalid phone number. It must be a 10-digit number starting with 7, 8, or 9."
    )
    private  String phNo;

}
