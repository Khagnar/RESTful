package ru.andersen.userREST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.andersen.userREST.entity.User;
import ru.andersen.userREST.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "get/{id}")
    public @ResponseBody String getUserById(@PathVariable long id) {
        return "User: " + userService.getUserById(id);
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userService.addUser(user);
        return "User " + user.getName() + " was added" ;
    }

    @PutMapping(path = "/update/{id}")
    public @ResponseBody String updateUser(@PathVariable long id, @RequestParam String name, @RequestParam String email) {
        userService.updateUser(id, name, email);
        return "User " + userService.getUserById(id).getName() + " was updated";
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "User with Id = " + id + " was deleted";
    }


}
