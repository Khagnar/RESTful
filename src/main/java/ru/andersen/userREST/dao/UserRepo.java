package ru.andersen.userREST.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andersen.userREST.entity.User;


public interface UserRepo extends JpaRepository<User, Long> {
}
