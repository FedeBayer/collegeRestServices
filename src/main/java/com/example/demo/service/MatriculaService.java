package com.example.demo.service;

import com.example.demo.model.Matricula;

import java.util.List;
import java.util.Optional;

public interface MatriculaService {
    List<Matricula> getAllMatriculas();

    Matricula saveMatricula(Matricula m);

    Optional<Matricula> getMatriculaById(long id);

    Matricula replaceMatricula(Matricula m, long id);

    void deleteMatriculaById(long id);
}
