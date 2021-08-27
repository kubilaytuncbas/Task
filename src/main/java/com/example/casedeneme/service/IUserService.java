package com.example.casedeneme.service;

import com.example.casedeneme.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User add(User user);
    void delete(int id);
    User update(User user);
    User login(User user);
    List<User> findAll();
    Optional<User> findById(int id);
}
