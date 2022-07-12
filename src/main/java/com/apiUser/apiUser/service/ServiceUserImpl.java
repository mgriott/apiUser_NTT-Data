package com.apiUser.apiUser.service;

import com.apiUser.apiUser.model.Users;
import com.apiUser.apiUser.repository.RepositoryUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceUserImpl implements ServiceUser {
    private final RepositoryUser repositoryUser;

    @Override
    public Users intoUser(Users user) {
        return repositoryUser.save(user);
    }

    @Override
    public Users getUser(Long idUser) {
        return repositoryUser.findById(idUser).orElseThrow(() -> {throw new RuntimeException();});
    }

    @Override
    public Users setUser(Long id, Users saveUser) {
        Users userFound = repositoryUser.findById(id).get();
        userFound.setMail(saveUser.getMail());
        userFound.setName(saveUser.getName());
        userFound.setPass(saveUser.getPass());
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
