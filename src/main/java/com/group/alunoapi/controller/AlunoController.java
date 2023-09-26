package com.group.alunoapi.controller;

import com.group.alunoapi.model.Aluno;
import com.group.alunoapi.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aluno> getAll() {
        return service.getAlunos();
    }

    @PostMapping
    public Aluno save(@RequestBody Aluno aluno) {
        return service.addAluno(aluno);
    }

    @DeleteMapping("/{alunoId}")
    public void delete(@PathVariable("alunoId") Long id) {
        service.excluirAluno(id);
    }

    @PutMapping("/{alunoId}")
    public Aluno update(@PathVariable("alunoId") Long id, @RequestParam(required = false) String nome, @RequestParam(required = false) String email) {
        return service.editarAluno(id, nome, email);
    }
}
