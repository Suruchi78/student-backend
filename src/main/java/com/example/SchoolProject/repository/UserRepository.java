package com.example.SchoolProject.repository;

import com.example.SchoolProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByUserNameAndPassword(String username, String password);
}
