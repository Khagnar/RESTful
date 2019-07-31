package ru.andersen.userREST.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.andersen.userREST.dao.UserRepo;
import ru.andersen.userREST.entity.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User getUserById(long id) {
        return userRepo.getOne(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void updateUser(long id, String name, String email) {
        User user = userRepo.getOne(id);
        user.setName(name);
        user.setEmail(email);
        userRepo.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }
}
