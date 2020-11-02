package com.hp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class Users {
    private  int id;
    private String username;
    private String password;
}
