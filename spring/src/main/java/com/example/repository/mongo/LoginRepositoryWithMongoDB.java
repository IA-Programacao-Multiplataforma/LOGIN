package com.example.repository.mongo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.repository.orm.LoginOrmMongo;

@Repository
public interface LoginRepositoryWithMongoDB extends MongoRepository<LoginOrmMongo, String> {
    Optional<LoginOrmMongo> findByUsername(String username);
    Optional<LoginOrmMongo> findByEmail(String email);
}