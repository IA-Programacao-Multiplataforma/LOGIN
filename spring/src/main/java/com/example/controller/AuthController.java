package com.example.controller;

import com.example.controller.adapter.AuthControllerAdapter;
import com.example.controller.dto.request.LoginRequest;
import com.example.controller.dto.response.AuthResponse;
import com.example.entity.Token;
import com.example.security.TokenSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
    @RestController
    @RequestMapping("/autenticacao")
    public class AuthController {

        private final TokenSecurity tokenSecurity;

        public AuthController(TokenSecurity tokenSecurity) {
            this.tokenSecurity = tokenSecurity;
        }

        @PostMapping("/login")
        public AuthResponse login(@RequestBody LoginRequest request) {
            System.out.println(">>> AGORA SIM CHEGOU NO CONTROLLER! <<<");
            try {
                // Tenta gerar o token
                Token token = tokenSecurity.gerarToken(AuthControllerAdapter.cast(request));
                System.out.println(">>> SUCESSO: TOKEN GERADO! <<<");

                return new AuthResponse(token.value());

            } catch (Exception e) {
                // Se o Spring tentar esconder o erro com um 403, a gente pega ele aqui!
                System.out.println("\n>>> 🚨 EXPLODIU NO LOGIN! MOTIVO 🚨 <<<");
                System.out.println("Erro: " + e.getClass().getSimpleName());
                System.out.println("Mensagem: " + e.getMessage());
                System.out.println(">>> ------------------------------- <<<\n");

                e.printStackTrace(); // Isso imprime o rastro vermelho completo

                throw e; // Repassa o erro para o sistema
            }
        }
    }

