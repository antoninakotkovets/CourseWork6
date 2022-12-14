package com.example.coursework6.repository;

import com.example.coursework6.model.Book;
import com.example.coursework6.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
    User findById(int userId);
    User findByLoginAndPassword(String login, String password);

}
