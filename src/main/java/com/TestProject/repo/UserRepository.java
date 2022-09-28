package com.TestProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TestProject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
