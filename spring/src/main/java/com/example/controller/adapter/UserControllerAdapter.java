package com.example.controller.adapter;

import com.example.controller.dto.request.UserRequest;
import com.example.entity.User;
import java.util.UUID;

public class UserControllerAdapter {

    private UserControllerAdapter() {}

    // Usado no POST (Registro)
    public static User cast(UserRequest request) {
        return new User(
                UUID.randomUUID().toString(), // Gera o ID automático aqui!
                request.username(),
                request.password(),
                request.email(),
                request.cep(),
                request.roles()
        );
    }

    // Usado no PUT (Atualização)
    public static User castPutRequest(UserRequest request) {
        return new User(
                request.id(), // Aqui ele usa o ID que veio no JSON
                request.username(),
                request.password(),
                request.email(),
                request.cep(),
                request.roles()
        );
    }
}