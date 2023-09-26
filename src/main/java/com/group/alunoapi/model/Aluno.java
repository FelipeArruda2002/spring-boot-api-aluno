package com.group.alunoapi.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @SequenceGenerator(
            name = "aluno_sequence",
            sequenceName = "aluno_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "aluno_sequence"
    )
    private Long id;
    private String nome;
    private String email;
    private Date dataAniversario;

    public Aluno() {}

    public Aluno(String nome, String email, Date dataAniversario) {
        this.nome = nome;
        this.email = email;
        this.dataAniversario = dataAniversario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(Date dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
}
