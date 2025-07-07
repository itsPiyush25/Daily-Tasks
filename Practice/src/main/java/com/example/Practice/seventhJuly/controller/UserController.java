package com.example.Practice.seventhJuly.controller;

import com.example.Practice.seventhJuly.request.UserRequest;
import com.example.Practice.seventhJuly.response.BaseResponse;
import com.example.Practice.seventhJuly.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserRequest request){
        BaseResponse response = userService.saveUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get-list")
    public ResponseEntity<?> getUserList(@RequestParam (required = false,defaultValue = "0")Integer pageNo ,
                                         @RequestParam (required = false,defaultValue = "15")Integer pageSize){
        BaseResponse response = userService.getUserList(pageNo,pageSize);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PatchMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId,@RequestBody UserRequest request){
        BaseResponse response = userService.updateUser(userId,request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        BaseResponse response = userService.deleteUser(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
