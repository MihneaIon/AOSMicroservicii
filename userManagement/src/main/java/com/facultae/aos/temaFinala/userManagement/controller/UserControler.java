package com.facultae.aos.temaFinala.userManagement.controller;

import com.facultae.aos.temaFinala.userManagement.model.User;
import com.facultae.aos.temaFinala.userManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControler {

    private UserService userService;

    @Autowired
    public UserControler(UserService userRepository) {
        this.userService = userRepository;
    }

    @RequestMapping(path = "/getUsers",method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    @RequestMapping(path = "/deleteAcccount/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteYourAccount(@PathVariable(value = "id")Long id)
    {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/updatePassword/{id}", method = RequestMethod.PUT)
    public ResponseEntity changeYourPassword(@PathVariable(value = "id")Long id,
                                            @Valid @RequestBody User myUser){
        return new ResponseEntity<>(userService.updateUser(id,myUser),HttpStatus.OK);
    }


    @RequestMapping(path = "/getUser/{id}",method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable(value = "id")Long id)
    {
        return new ResponseEntity<>(userService.getUser(id),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUsers(user),HttpStatus.OK);
    }

}
