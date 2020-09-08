package com.example.upgradProject.upgradProject.repository;

import com.example.upgradProject.upgradProject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
