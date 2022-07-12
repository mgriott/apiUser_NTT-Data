package com.apiUser.apiUser.controller;

import com.apiUser.apiUser.model.Users;
import com.apiUser.apiUser.service.ServiceUser;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.debugger.posix.elf.ELFSectionHeader;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class ControllerUser {

    private final ServiceUser serviceUser;
    public Map<String, String> msj = new HashMap<String, String>();
    @PostMapping
    public ResponseEntity intoUser(@RequestBody Users user){


        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        if (pattern.matcher(user.getMail()).matches()){
            msj.put("mensaje", "Exito");
            //UUID.fromString()
            return new ResponseEntity(serviceUser.intoUser(user) + msj.toString(), HttpStatus.CREATED);
        }
        else
        {
            msj.put("mensaje", "Error");
            return new ResponseEntity(msj.toString(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity getUser(@PathVariable("userId") Long idUser){
        msj.put("mensaje", "Exito");
        return new ResponseEntity(serviceUser.getUser(idUser) + msj.toString(), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity setUser(@PathVariable("userId") Long idUser, @RequestBody Users user){
        msj.put("mensaje", "Exito");
        return new ResponseEntity(serviceUser.setUser(idUser, user) + msj.toString(), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity delUser(@PathVariable("userId") Long idUser){
        boolean reply = serviceUser.delUser(idUser);
        if(reply == true){
            msj.put("mensaje", "Exito");
            return new ResponseEntity(msj.toString(), HttpStatus.OK);
        }
        else {
            msj.put("mensaje", "Manejando Error");
            return new ResponseEntity(msj.toString(), HttpStatus.NOT_FOUND);
        }
    }
}
