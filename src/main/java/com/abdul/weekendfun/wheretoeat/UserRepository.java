package com.abdul.weekendfun.wheretoeat;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author by AbdulQader
 * on 16/9/2019.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
}
