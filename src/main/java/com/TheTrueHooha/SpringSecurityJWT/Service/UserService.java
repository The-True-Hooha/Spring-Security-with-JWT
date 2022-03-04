package com.TheTrueHooha.SpringSecurityJWT.Service;

import com.TheTrueHooha.SpringSecurityJWT.Models.AppRole;
import com.TheTrueHooha.SpringSecurityJWT.Models.AppUser;

import java.util.List;

public interface UserService {

    //method that saves the user information
    AppUser saveUser (AppUser appUser);
    AppRole saveRole (AppRole appRole);

    void addRoleToUser (String username, String roleName); //ensure that no two users are added with the same username
    AppUser getUser(String username); //gets a particular username
    AppUser getEmail(String email);
    List<AppUser> getAllUsers(); //return a list of all the users

}
