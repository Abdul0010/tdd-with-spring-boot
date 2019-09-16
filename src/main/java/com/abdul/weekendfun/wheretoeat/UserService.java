package com.abdul.weekendfun.wheretoeat;

import org.springframework.stereotype.Service;

/**
 * @Author by AbdulQader
 * on 16/9/2019.
 */
public interface UserService {

    public User findUser(String name);

    public User save(User user);
}
