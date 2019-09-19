package com.abdul.weekendfun.wheretoeat;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Author by AbdulQader
 * on 16/9/2019.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String name);
}
