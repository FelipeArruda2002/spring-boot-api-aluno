package com.group.alunoapi.config;

import com.group.alunoapi.model.Aluno;
import com.group.alunoapi.repository.AlunoRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Configuration
public class AlunoConfig {

    @Bean
    CommandLineRunner commandLineRunner(AlunoRepo repository) {
        return args -> {
            Aluno felipe = new Aluno("Felipe", "felipe@gmail.com", new Date());
            Aluno dani = new Aluno("Daniela", "dani@gmail.com", new Date());

            repository.saveAll(List.of(felipe, dani));
        };
    }

}
