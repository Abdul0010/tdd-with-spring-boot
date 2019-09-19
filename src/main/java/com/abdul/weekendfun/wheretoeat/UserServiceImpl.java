package com.abdul.weekendfun.wheretoeat;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return userRepository.findByName(name)
                .orElseThrow(()->new RuntimeException("user not found"));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(long anyLong) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> update(Long id, User userUpdatedDetails) {
        return userRepository.findById(id).
                map(user->{
                    user.setName(userUpdatedDetails.getName());
                    user.setUserType(userUpdatedDetails.getUserType());
                    user.setNationality(userUpdatedDetails.getNationality());
                    return userRepository.save(user);
                });

    }
}
