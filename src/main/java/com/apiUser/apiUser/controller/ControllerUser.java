package com.apiUser.apiUser.controller;

import com.apiUser.apiUser.model.User;
import com.apiUser.apiUser.service.ServiceUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.debugger.posix.elf.ELFSectionHeader;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class ControllerUser {

    private final ServiceUser serviceUser;

    @PostMapping
    public ResponseEntity intoUser(@RequestBody User user){
        return new ResponseEntity(serviceUser.intoUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable("id") Long idUser){
        return new ResponseEntity(serviceUser.getUser(idUser), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity setUser(@PathVariable("id") Long idUser, @RequestBody User user){
        return new ResponseEntity(serviceUser.setUser(idUser, user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delUser(@PathVariable("id") Long idUser){
        boolean reply = serviceUser.delUser(idUser);
        if(reply == true){
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
