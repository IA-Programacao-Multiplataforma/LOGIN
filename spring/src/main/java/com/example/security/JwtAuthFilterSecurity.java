package com.example.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthFilterSecurity extends OncePerRequestFilter {
    private final JwtSecurity jwt;
    private final UserDetailsService service;

    public JwtAuthFilterSecurity(JwtSecurity jwt, UserDetailsService service) {
        this.jwt = jwt;
        this.service = service;
    }

    // --- ADICIONE ESTE MÉTODO AQUI ---
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getServletPath();
        // Isso diz: "Se o caminho for /login/registro, nem ligue o filtro!"
        return path.startsWith("/login/registro");
    }
    // --------------------------------

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        // ... (o resto do seu código continua igual aqui embaixo)
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            // ... lógica do token
        }
        filterChain.doFilter(request, response);
    }
}