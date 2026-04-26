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

    // O método de salvar que você já tinha feito!
    @Override
    public User salvar(User login) {
        LoginOrmMongo orm = LoginRepositoryAdapter.castEntity(login);
        return LoginRepositoryAdapter.castOrm(repository.save(orm));
    }

    // O método de deletar que o Java estava sentindo falta!
    @Override
    public void deletar(String id) {
        repository.deleteById(id);
    }

    // O método de busca que vai gerar o nosso Token!
    @Override
    public User findByUsername(String username) {
        LoginOrmMongo orm = repository.findByUsername(username);

        if (orm == null) {
            return null;
        }

        return LoginRepositoryAdapter.castOrm(orm);
    }

    @Override
    public User findByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}