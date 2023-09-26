package com.group.alunoapi.service;

import com.group.alunoapi.model.Aluno;
import com.group.alunoapi.repository.AlunoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepo repository;

    public List<Aluno> getAlunos() {
        return repository.findAll();
    }

    public Aluno addAluno(Aluno aluno) {
        Optional<Aluno> alunoOptional = repository.findAlunoByEmail(aluno.getEmail());

        if (alunoOptional.isPresent()) {
            throw new IllegalArgumentException("Email já existe em nossa base de dados.");
        }

        return repository.save(aluno);
    }

    public void excluirAluno(Long id) {
        boolean exists = repository.existsById(id);

        if (!exists) {
            throw new IllegalArgumentException(String.format("Aluno de ID: %d não existe", id));
        }

        repository.deleteById(id);
    }

    @Transactional
    public Aluno editarAluno(Long id, String nome, String email) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Aluno de ID: %d não existe", id)));

                if (nome != null && nome.length() > 0 && !Objects.equals(nome, aluno.getNome())) {
                    aluno.setNome(nome);
                }


                if (email != null && email.length() > 0 && !Objects.equals(email, aluno.getEmail())) {
                    Optional<Aluno> alunoOptional = repository.findAlunoByEmail(email);

                    if (alunoOptional.isPresent()) {
                        throw new IllegalArgumentException("Email já existe em nossa base de dados.");
                    }

                    aluno.setEmail(email);
                }


        return  repository.save(aluno);
    }

}
