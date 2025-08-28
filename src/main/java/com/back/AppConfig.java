package com.back;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public PersonRepository personRepository() {
        return new PersonRepository(1);
    }

    @Bean
    public PersonRepository personRepositoryV2() {
        return new PersonRepository(2);
    }

}
