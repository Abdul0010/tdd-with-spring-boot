package com.abdul.weekendfun.wheretoeat;

import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * @Author by AbdulQader
 * on 16/9/2019.
 */
public interface UserService {

    public User findUser(String name);

    public User save(User user);

   public User findById(long anyLong);

    public List<User> findAll();

    Optional<User> update(Long id, User user);
}
