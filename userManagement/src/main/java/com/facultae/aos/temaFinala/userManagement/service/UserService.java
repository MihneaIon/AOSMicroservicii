package com.facultae.aos.temaFinala.userManagement.service;

import com.facultae.aos.temaFinala.userManagement.model.User;

import java.util.List;

public interface UserService {

    User addUsers(User user);

    void deleteUser(long id);

    User updateUser(long userId, User user);

    User getUser(long id);

    List<User> getAllUsers();

}
