package com.example.Practice.seventhJuly.service;

import com.example.Practice.seventhJuly.exception.UserNameAlreadyExistException;
import com.example.Practice.seventhJuly.exception.UserNotFoundException;
import com.example.Practice.seventhJuly.model.Users;
import com.example.Practice.seventhJuly.repository.UsersRepository;
import com.example.Practice.seventhJuly.request.UserRequest;
import com.example.Practice.seventhJuly.response.BaseResponse;
import com.example.Practice.seventhJuly.response.UserResponse;
import com.example.Practice.utilities.ExistenceCheckStrategy;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    private final UsersRepository usersRepository;

    private ExistenceCheckStrategy strategy;

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public BaseResponse saveUser(UserRequest request) {
        log.info("UserService ----------{}---------saveUser()-----initialize save user method");

        Users users = new Users();
        userDtoToEntity(request, users);
        usersRepository.save(users);

        return BaseResponse.builder()
                .data("user generated successfully...")
                .success(true)
                .build();

    }

    private void userDtoToEntity(UserRequest request, Users users) {
        users.setName(request.getUserName());
        users.setMail(request.getEmail());
        users.setOccupation(request.getOccupation());
        users.setMobileNo(request.getMobileNo());
        users.setBloodGroup(request.getBloodGroup());
        users.setName(request.getName());
        List<Users> existingUsername = usersRepository.findByUsername(request.getUserName());

        if (!existingUsername.isEmpty())
            throw new UserNameAlreadyExistException("Username : "+ request.getUserName()+" is already present.");
        else
            users.setUsername(request.getUserName());
//        users.setPassword(passwordEncoder().encode(request.getPassword()));
        users.setPassword(request.getPassword());
    }

    public BaseResponse getUserList(Integer pageNo, Integer pageSize) {

        Page<Users> all = usersRepository.findAll(PageRequest.of(pageNo,pageSize));

        List<UserResponse> userResponseList = new ArrayList<>();

        for (Users users : all) {
            UserResponse response = new UserResponse();
            response.setUserName(users.getUsername());
            response.setEmail(users.getMail());
            response.setOccupation(users.getOccupation());
            response.setBloodGroup(users.getBloodGroup());
            response.setPassword(users.getPassword());
            response.setMobileNo(users.getMobileNo());
            userResponseList.add(response);
        }
        return BaseResponse.builder()
                .data(userResponseList)
                .message("User list fetched successfully...")
                .success(true)
                .build();
    }

    public BaseResponse updateUser(Long userId, UserRequest patchRequest) {
        Optional<Users> usersOptional = Optional.ofNullable(usersRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found...")));

        Users user = usersOptional.get();
        if (patchRequest.getEmail() != null) {
            user.setMail(patchRequest.getEmail());
        }
        if (patchRequest.getMobileNo() != null) {
            user.setMobileNo(patchRequest.getMobileNo());
        }


        if (patchRequest.getUserName() != null) {
            user.setUsername(patchRequest.getUserName());
        }
        if (patchRequest.getOccupation() != null) {
            user.setOccupation(patchRequest.getOccupation());
        }
        if (patchRequest.getName() != null) {
            user.setName(patchRequest.getName());
        }
        if (patchRequest.getBloodGroup() != null) {
            user.setBloodGroup(patchRequest.getBloodGroup());
        }
        if (patchRequest.getPassword() != null) {
            user.setPassword(patchRequest.getPassword());
        }
        usersRepository.save(user);

        return BaseResponse.builder()
                .data("User updated successfully...")
                .build();
    }

    public BaseResponse deleteUser(Long userId) {

        Optional<Users> usersOptional = Optional.ofNullable(usersRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found...")));

        usersOptional.get().setActive(false);

        usersRepository.save(usersOptional.get());

        return BaseResponse.builder()
                .data("User with id : "+userId+" is deleted successfully...")
                .build();
    }
}
