package com.maven.bookService.repository;

import com.maven.bookService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The UserRepository is used for CRUD operation for User table
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
