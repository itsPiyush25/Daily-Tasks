package com.example.Practice.seventhJuly.repository;

import com.example.Practice.seventhJuly.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    List<Users> findByUsername(String username);
}
