package com.vic.demo.model;

import lombok.Data;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

@Data
public class User {

    private Long id;

    private String username;

    private String password;

    private String email;

    private Date lastPasswordResetDate;

//    private List<String> roles;

}
