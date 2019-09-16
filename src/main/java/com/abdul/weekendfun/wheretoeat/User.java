package com.abdul.weekendfun.wheretoeat;

import lombok.Data;

/**
 * @Author by AbdulQader
 * on 16/9/2019.
 */
@Data
public class User {
    private Long id;
    private String name;
    private String userType;
    private String nationality;

    public User(String name, String userType, String nationality) {
        this.name = name;
        this.userType = userType;
        this.nationality = nationality;
    }
}
