package com.TheTrueHooha.SpringSecurityJWT.Repository;

import com.TheTrueHooha.SpringSecurityJWT.Models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername (String username);
    AppUser findByEmail (String email);
}
