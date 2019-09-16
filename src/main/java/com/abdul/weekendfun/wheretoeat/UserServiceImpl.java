package com.abdul.weekendfun.wheretoeat;

import org.springframework.stereotype.Service;

/**
 * @Author by AbdulQader
 * on 16/9/2019.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUser(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
