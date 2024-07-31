package com.example.entities;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.roles.UserRoles;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String username;
    private String name;
    private String password;    
    private String rg;
    private String cpf;
    private UserRoles role;



    public User(String username, String name, String password, String rg, String cpf, UserRoles role){
        this.username = username;
        this.name = name;
        this.cpf = cpf; 
        this.password = password;
        this.rg = rg;
        this.role = role;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(role == UserRoles.ADMIN) {
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    
    @Override
    public String getPassword() {
        return password;
    }



    @Override
    public String getUsername() {
        return username;
    }

    public String getName(){
        return name;
    }
}
