package com.aaron.osahaneat.repository;

import com.aaron.osahaneat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInterface extends JpaRepository<User, Integer> {
}
