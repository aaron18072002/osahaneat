package com.aaron.osahaneat.repository;

import com.aaron.osahaneat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInterface extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users AS U WHERE " +
                   "U.user_name = :userName AND U.password = :password",
            nativeQuery = true)
    List<User> findByUsernameAndPassword(@Param("userName") String userName,
                                         @Param("password") String password);

}
