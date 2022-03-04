package com.TheTrueHooha.SpringSecurityJWT.Repository;

import com.TheTrueHooha.SpringSecurityJWT.Models.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole, Long> {

    AppRole findByName (String name);
}
