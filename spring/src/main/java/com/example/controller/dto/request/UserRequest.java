package com.example.controller.dto.request;

import com.example.entity.enumerable.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record UserRequest(
        @JsonProperty("id") String id, // No registro ele virá null, e tudo bem!
        @JsonProperty("username") String username,
        @JsonProperty("password") String password,
        @JsonProperty("email") String email,
        @JsonProperty("cep") String cep,
        @JsonProperty("roles") List<UserRole> roles) {
}