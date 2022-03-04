package com.TheTrueHooha.SpringSecurityJWT.Impl;

import com.TheTrueHooha.SpringSecurityJWT.Models.AppRole;
import com.TheTrueHooha.SpringSecurityJWT.Models.AppUser;
import com.TheTrueHooha.SpringSecurityJWT.Repository.RoleRepository;
import com.TheTrueHooha.SpringSecurityJWT.Repository.UserRepository;
import com.TheTrueHooha.SpringSecurityJWT.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    //if the user does not exist in the database
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username);
        if (user == null) {
            log.error("this user is not found");
            throw new UsernameNotFoundException("this username is not valid");
        } else {
            log.info("user exists: {}", username);
        }

        //loops through every user and then grants authority
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(appRole -> {
            authorities.add(new SimpleGrantedAuthority(appRole.getName()));
        });
        return new org.springframework.security.core.userdetails.User
                (user.getUsername(), user.getPassword(), authorities);
    }

    //saves the user to the database
    @Override
    public AppUser saveUser(AppUser appUser) {
        log.info("saving the new user {} to the database", appUser.getName());
        return userRepository.save(appUser);
    }

    //adds and saves a new granted role
    @Override
    public AppRole saveRole(AppRole appRole) {
        log.info("saving new user role {} to user", appRole.getName());
        return roleRepository.save(appRole);
    }


    //adds a given role to the user
    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("adding role{} to user {} to the database", roleName, username);
        AppUser appUser = userRepository.findByUsername(username);
        AppRole appRole = roleRepository.findByName(roleName);
        appUser.getRoles().add(appRole);
    }


    //gets the user by username
    @Override
    public AppUser getUser(String username) {
        log.info("retrieving user {}", username);
        return userRepository.findByUsername(username);
    }


    //gets the user by email
    @Override
    public AppUser getEmail(String email) {
        log.info("retrieving email {}", email);
        return userRepository.findByEmail(email);
    }


    //gets all the users from the database
    @Override
    public List<AppUser> getAllUsers() {
        log.info("retrieving ll the user in the database");
        return userRepository.findAll();
    }


}
