package com.creativefuel.login_authentication.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyUser,Long> {

    Optional<MyUser> findByUsername(String username);
}
