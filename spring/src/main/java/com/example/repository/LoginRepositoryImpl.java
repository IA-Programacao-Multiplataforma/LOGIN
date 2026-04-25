package com.example.repository;

import com.example.entity.User;
import com.example.repository.adapter.LoginRepositoryAdapter;
import com.example.repository.mongo.LoginRepositoryWithMongoDB;
import com.example.repository.orm.LoginOrmMongo;
import org.springframework.stereotype.Repository;

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
        return null;
    }
}