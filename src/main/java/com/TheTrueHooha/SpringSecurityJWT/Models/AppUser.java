package com.TheTrueHooha.SpringSecurityJWT.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //user parameters
    private Long id;
    private String name;
    private String username;
    private String password;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER) //loads all the roles when a user is fetched
    private Collection<AppRole> roles = new ArrayList<>();
}
