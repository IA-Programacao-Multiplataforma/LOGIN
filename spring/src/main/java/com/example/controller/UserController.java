package com.example.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.adapter.UserControllerAdapter;
import com.example.controller.dto.request.UserRequest;
import com.example.entity.User;
import com.example.repository.LoginRepository;

@RestController
@RequestMapping("/login")
public class UserController {

    private final LoginRepository repository;

    public UserController(LoginRepository repository) {
        this.repository = repository;
    }

    // Rota para criar usuário (Registro)
    @PostMapping("/registro")
    public User criar(@RequestBody UserRequest request) {
        User novoLogin = UserControllerAdapter.cast(request);
        return repository.salvar(novoLogin);
    }
    @GetMapping
    public String getLogin() {
        return "Realizar Login";
    }

    @PutMapping
    public User atualizar(@RequestBody UserRequest request) {
        User loginAtualizado = UserControllerAdapter.castPutRequest(request);
        return repository.salvar(loginAtualizado);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable String id) {
        repository.deletar(id);
        return "Login deletado do banco";
    }
}