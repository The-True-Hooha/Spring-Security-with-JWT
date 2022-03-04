package com.TheTrueHooha.SpringSecurityJWT.Impl;

import com.TheTrueHooha.SpringSecurityJWT.Models.AppRole;
import com.TheTrueHooha.SpringSecurityJWT.Models.AppUser;
import com.TheTrueHooha.SpringSecurityJWT.Service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public AppUser saveUser(AppUser appUser) {
        return null;
    }

    @Override
    public AppRole saveRole(AppRole appRole) {
        return null;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

    }

    @Override
    public AppUser getUser(String username) {
        return null;
    }

    @Override
    public List<AppUser> getAllUsers() {
        return null;
    }
}
