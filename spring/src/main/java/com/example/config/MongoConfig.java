package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        // Isso obriga o sistema a usar este banco, não importa o que o IntelliJ ache.
        return "pm";
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}