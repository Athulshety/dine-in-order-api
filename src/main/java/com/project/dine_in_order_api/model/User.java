package com.project.dine_in_order_api.model;

import com.project.dine_in_order_api.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
 public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId")
    private long userId;

   @Column(name="userName")
    private String userName;

   @Column(name="email")
    private String email;

   @Column(name="password")
    private String password;

   @Column(name="phNo")
    private String phNo;

   @Column(name="userRole")
   @Enumerated(EnumType.STRING)
   private UserRole userRole;

   @Column(name="createdAt")
    private LocalDate createdAt;

   @Column(name="lastmodifiedAt")
    private LocalDate lastModifiedAt;

}
