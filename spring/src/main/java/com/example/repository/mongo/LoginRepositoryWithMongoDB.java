package com.example.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.repository.orm.LoginOrmMongo;

public interface LoginRepositoryWithMongoDB extends MongoRepository<LoginOrmMongo, String> {
    // O Spring Boot vai criar a lógica de busca automaticamente só por causa desse nome!
    LoginOrmMongo findByUsername(String username);
}