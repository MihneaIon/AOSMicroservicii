package com.facultae.aos.temaFinala.userManagement.service;

import com.facultae.aos.temaFinala.userManagement.model.User;
import com.facultae.aos.temaFinala.userManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    @Override
    public User addUsers(User user) {

        return userRepository.saveAndFlush(user);
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updateUser(long userId, User user) {
        User userUpdate= getUser(userId);
        userUpdate.setName(user.getName());
        userUpdate.setPassword(user.getPassword());
        return userRepository.saveAndFlush(userUpdate);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
