package com.example.dto;

import com.example.roles.UserRoles;

public record createUserDTO(
    String username,
    String name,
    String password,
    String rg,
    String cpf,
    UserRoles role
) {


}
