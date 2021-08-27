package com.example.casedeneme.service;

import Regex.EmailRegex;
import com.example.casedeneme.dao.UserDao;
import com.example.casedeneme.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManager implements IUserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User add(User user) {
        if (!EmailRegex.isEmailValid(user.getEmail())){
          System.out.println("Email yapısına uymuyor");
          return null;
        }
        else return userDao.save(user);


    }

    @Override
    public void delete(int id) {
        userDao.deleteById(id);
    }

    @Override
    public User update(User user) {
        return userDao.save(user);
    }

    @Override
    public User login(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return userDao.findById(id);
    }


}
