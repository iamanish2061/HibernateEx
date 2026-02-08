package com.hiber.controller;

import com.hiber.model.UserModel;
import com.hiber.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

@RequiredArgsConstructor
@RequestMapping("/api/mobile-programming/")
@CrossOrigin(origins = "*")
public class MPController {

    private final UserRepo userRepo;

    @GetMapping("/get-data")
    public ResponseEntity<?> getData(){
        List<UserModel> users = userRepo.findAll();
        if(users.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("data", "No user found"));
        return ResponseEntity.ok(Map.of("data", users));
    }

    @PostMapping("/put-data")
    public ResponseEntity<?> putData(
            @RequestBody UserModel user
    ){
        UserModel savedUser = userRepo.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/update-name")
    public ResponseEntity<?> updateName(
            @RequestBody UserModel userRequest
    ){
        UserModel user = userRepo.findById(userRequest.getId()).orElseGet(null);
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            user.setName(userRequest.getName());
            user.setAddress(userRequest.getAddress());
            userRepo.save(user);
            return ResponseEntity.ok(Map.of("success", true));
        }
    }

    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<?> deleteStudent(
            @PathVariable Long id
    ){
        UserModel user = userRepo.findById(id).orElseGet(null);
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            userRepo.delete(user);
            return ResponseEntity.ok(Map.of("success", true));
        }
    }



}
