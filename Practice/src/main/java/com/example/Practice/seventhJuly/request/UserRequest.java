package com.example.Practice.seventhJuly.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String userName;
    private String password;
    private String email;
    private String occupation;
    private String mobileNo;
    private String bloodGroup;
    private String name;
}
