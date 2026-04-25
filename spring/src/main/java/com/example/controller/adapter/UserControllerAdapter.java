package com.example.controller.adapter;

import com.example.controller.dto.request.UserRequest;
import java.util.UUID;
import com.example.entity.User;

public class UserControllerAdapter {
    private UserControllerAdapter() {}

    public static com.example.entity.User cast(UserRequest request) {
        return new User(
                UUID.randomUUID().toString(),
                request.username(),
                request.password(),
                request.email(),
                request.cep(),
                request.roles());
    }

    public static com.example.entity.User castPutRequest(UserRequest request) {
        return new User(request.id(), request.username(), request.password(), request.email(), request.cep(), request.roles());
    }
}