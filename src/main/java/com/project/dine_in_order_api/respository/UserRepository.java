package com.project.dine_in_order_api.respository;

import com.project.dine_in_order_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
