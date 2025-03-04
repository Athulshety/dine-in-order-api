package com.project.dine_in_order_api.dto.response;

import com.project.dine_in_order_api.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
public class UserResponse {
    private  long userId;
    private String userName;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private LocalDate createdAt;
    private LocalDate lastModifiedAt;
}
