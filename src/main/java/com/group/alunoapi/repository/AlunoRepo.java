package com.group.alunoapi.repository;

import com.group.alunoapi.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepo extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findAlunoByEmail(String email);

}
