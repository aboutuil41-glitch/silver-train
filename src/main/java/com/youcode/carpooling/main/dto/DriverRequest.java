package com.youcode.carpooling.main.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DriverRequest(
        @NotBlank String lastName,
        @NotBlank String firstName,
        @NotBlank @Email String email,
        @NotBlank String phone,
        @NotBlank String licenseNumber
) {}
