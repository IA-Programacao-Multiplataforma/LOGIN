package com.example.repository;

import org.springframework.stereotype.Repository;

import com.example.entity.User;
import com.example.repository.adapter.LoginRepositoryAdapter;
import com.example.repository.mongo.LoginRepositoryWithMongoDB;
import com.example.repository.orm.LoginOrmMongo;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

    private final LoginRepositoryWithMongoDB repository;

    public LoginRepositoryImpl(LoginRepositoryWithMongoDB repository) {
        this.repository = repository;
    }

    @Override
    public User salvar(User login) {
        LoginOrmMongo orm = LoginRepositoryAdapter.castEntity(login);
        return LoginRepositoryAdapter.castOrm(repository.save(orm));
    }

    @Override
    public void deletar(String id) {
        repository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username)
                .map(LoginRepositoryAdapter::castOrm) // Converte ORM -> Entity
                .orElse(null); // Retorna null se não achar
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email)
                .map(LoginRepositoryAdapter::castOrm)
                .orElse(null);
    }
}