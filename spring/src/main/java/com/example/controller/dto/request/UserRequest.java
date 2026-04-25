package com.example.controller.dto.request;

import com.example.entity.enumerable.UserRole;
import java.util.List;

public record UserRequest(
    String id, 
    String username, 
    String password, 
    String email,
    String cep,
    List<UserRole> roles) {

}