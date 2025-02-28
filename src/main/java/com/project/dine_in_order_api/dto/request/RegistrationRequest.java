package com.project.dine_in_order_api.dto.request;

import com.project.dine_in_order_api.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class RegistrationRequest {

    private String userName;
    private String email;
    private String password;
    private String phNo;
    private UserRole userRole;

}
