package com.tantai.crudapi.services;

import com.tantai.crudapi.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);

    List<User> findAll();

    Optional<User> getUserById(Integer id);

    void deleteUserById(Integer id);

}
