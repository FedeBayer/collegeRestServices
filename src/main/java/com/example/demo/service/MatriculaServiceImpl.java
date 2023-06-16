package com.example.demo.service;

import com.example.demo.model.Matricula;
import com.example.demo.repository.CarreraRepository;
import com.example.demo.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {
    private MatriculaRepository repository;
    private CarreraRepository c;

    @Autowired
    public MatriculaServiceImpl(MatriculaRepository repository, CarreraRepository c) {
        this.repository = repository;
        this.c = c;
    }

    @Override
    public List<Matricula> getAllMatriculas() {
        return repository.findAll();
    }

    @Override
    public Matricula saveMatricula(Matricula m) {
    	c.getOne(m.getId_carrera().getId()).aumentarCantEstudiantes();
        return repository.save(m);
    }

    @Override
    public Optional<Matricula> getMatriculaById(long id) {
        return Optional.of(repository.getOne(id));
    }

    @Override
    public Matricula replaceMatricula(Matricula m, long id) {
        return repository.findById(id)
                .map(matricula -> {
                    matricula.setLibreta_uni_estudiante(m.getLibreta_uni_estudiante());
                    matricula.setId_carrera(m.getId_carrera());
                    matricula.setAntiguedad(m.getAntiguedad());
                    matricula.setAntiguedad(m.getAntiguedad());
                    matricula.setGraduado((m.isGraduado()));
                    matricula.setAnio_cursada((m.getAnio_cursada()));
                    return repository.save(matricula);
                })
                .orElseGet(() -> {
                    //newMatricula.setLibreta_uni_estudiante(id);
                    return repository.save(m);
                });
    }

    @Override
    public void deleteMatriculaById(long id) {
        repository.deleteById(id);
    }
}
