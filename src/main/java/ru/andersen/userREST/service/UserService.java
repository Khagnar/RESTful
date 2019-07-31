package ru.andersen.userREST.service;

import ru.andersen.userREST.entity.User;

import java.util.List;

public interface UserService {

    User getUserById(long id);
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(long id, String name, String email);
    void deleteUser(long id);
}
