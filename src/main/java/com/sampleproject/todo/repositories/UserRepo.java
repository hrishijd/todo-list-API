package com.sampleproject.todo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sampleproject.todo.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	Optional<User> findById(Integer id);
}
