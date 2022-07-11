package com.apiUser.apiUser.service;

import com.apiUser.apiUser.model.User;

import java.util.Optional;

public interface ServiceUser {
    User intoUser(User user);

    User getUser(Long idUser);

    User setUser(Long id, User saveUser);

    boolean delUser(Long id);
}
