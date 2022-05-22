package com.back.computernetworkback.repository;

import com.back.computernetworkback.enity.Otdel;
import com.back.computernetworkback.enity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserByEmail(String email);

    List<User> findUserByOtdel(Otdel otdel);
}
