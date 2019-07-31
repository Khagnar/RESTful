package ru.andersen.userREST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.andersen.userREST.entity.User;
import ru.andersen.userREST.dao.UserRepo;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserRepo userRepo;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping(path = "get/{id}")
    public @ResponseBody String getUserById(@PathVariable long id) {
        return "User: " + userRepo.getOne(id);
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody List<User> getAllUsers() {
        List<User> list = userRepo.findAll();
        return list;
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepo.save(user);
        return "User " + user.getName() + " was added" ;
    }

    @PutMapping(path = "/update/{id}")
    public @ResponseBody String updateUser(@PathVariable long id, @RequestParam String name, @RequestParam String email) {
        User user = userRepo.getOne(id);
        user.setName(name);
        user.setEmail(email);
        userRepo.save(user);
        return "User " + user.getName() + " was updated";
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteUser(@PathVariable long id) {
        userRepo.deleteById(id);
        return "User with Id = " + id + " was deleted";
    }


}
