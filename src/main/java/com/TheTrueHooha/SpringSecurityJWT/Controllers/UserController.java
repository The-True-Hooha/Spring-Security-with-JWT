package com.TheTrueHooha.SpringSecurityJWT.Controllers;

import com.TheTrueHooha.SpringSecurityJWT.Models.AppRole;
import com.TheTrueHooha.SpringSecurityJWT.Models.AppUser;
import com.TheTrueHooha.SpringSecurityJWT.Service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @GetMapping("/all-users")
    public ResponseEntity<List<AppUser>>getUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping("/new-user/save")
    public ResponseEntity<AppUser>saveUser(@RequestBody AppUser appUser) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/new-user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(appUser));
    }

    @PostMapping("/role/save")
    public ResponseEntity<AppRole>saveRole(@RequestBody AppRole appRole) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(appRole));
    }

    @PostMapping("/role/add-to-user")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm roleToUserForm) {
        userService.addRoleToUser(roleToUserForm.getUsername(), roleToUserForm.getRoleName());
        return ResponseEntity.ok().build();
    }

}

    @Data
    class RoleToUserForm {
        private String username;
        private String roleName;
    }
