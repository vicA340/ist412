package com.example.atzfinance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.atzfinance.Model.User;
 
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
