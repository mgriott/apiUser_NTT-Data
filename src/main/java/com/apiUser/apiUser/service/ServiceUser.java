package com.apiUser.apiUser.service;

import com.apiUser.apiUser.model.Users;

import java.util.Optional;

public interface ServiceUser {
    Users intoUser(Users user);

    Users getUser(Long idUser);

    Users setUser(Long id, Users saveUser);

    boolean delUser(Long id);
}
