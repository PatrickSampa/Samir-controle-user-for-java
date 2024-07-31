package com.example.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
    @NotBlank
    String username,
    @NotBlank
    String password
) {}
