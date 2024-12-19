package com.aaron.osahaneat.repository;

import com.aaron.osahaneat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users AS U WHERE " +
                   "U.user_name = :userName AND U.password = :password",
            nativeQuery = true)
    List<User> findByUsernameAndPassword(@Param("userName") String userName,
                                         @Param("password") String password);

    @Query(value = "SELECT * FROM users",
        nativeQuery = true)
    List<User> getAllUsers();

    @Query(value = "SELECT * FROM users WHERE user_name = :user_name",
        nativeQuery = true)
    Optional<User> findByUsername(@Param("user_name") String userName);

}
