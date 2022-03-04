package com.TheTrueHooha.SpringSecurityJWT.Impl;

import com.TheTrueHooha.SpringSecurityJWT.Models.AppRole;
import com.TheTrueHooha.SpringSecurityJWT.Models.AppUser;
import com.TheTrueHooha.SpringSecurityJWT.Repository.RoleRepository;
import com.TheTrueHooha.SpringSecurityJWT.Repository.UserRepository;
import com.TheTrueHooha.SpringSecurityJWT.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser appUser) {
        log.info("saving the new user {} to the database", appUser.getName());
        return userRepository.save(appUser);
    }

    @Override
    public AppRole saveRole(AppRole appRole) {
        log.info("saving new user role {} to user", appRole.getName());
        return roleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("adding role{} to user {} to the database", roleName, username);
        AppUser appUser = userRepository.findByUsername(username);
        AppRole appRole = roleRepository.findByName(roleName);
        appUser.getRoles().add(appRole);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("retrieving user {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getAllUsers() {
        log.info("retrieving ll the user in the database");
        return userRepository.findAll();
    }
}
