package com.apiUser.apiUser.service;

import com.apiUser.apiUser.model.User;
import com.apiUser.apiUser.repository.RepositoryUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceUserImpl implements ServiceUser {
    private final RepositoryUser repositoryUser;

    @Override
    public User intoUser(User user) {
        return repositoryUser.save(user);
    }

    @Override
    public User getUser(Long idUser) {
        return repositoryUser.findById(idUser).orElseThrow(() -> {throw new RuntimeException();});
    }

    @Override
    public User setUser(Long id, User saveUser) {
        User userFound = repositoryUser.findById(id).get();
        userFound.setMail(saveUser.getMail());
        return repositoryUser.save(userFound);
    }

    @Override
    public boolean delUser(Long id) {
        try{
            repositoryUser.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
