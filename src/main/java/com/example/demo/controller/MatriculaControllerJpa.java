package com.example.demo.controller;

import com.example.demo.model.Matricula;
import com.example.demo.service.MatriculaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("matriculas")
@Api(value = "MatriculaControllerJpa", description = "REST API Matricula description")
public class MatriculaControllerJpa {

    @Qualifier("matriculaServiceImpl")
    @Autowired
    private final MatriculaService service;

    public MatriculaControllerJpa(@Qualifier("matriculaServiceImpl") MatriculaService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get list of matriculas", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @GetMapping("")
    public Iterable<Matricula> getMatriculas() {
        return service.getAllMatriculas();
    }

    @ApiOperation(value = "Save a matricula ", response = Matricula.class)
    @PostMapping("")
    public Matricula newMatricula(@RequestBody Matricula m) {
        return service.saveMatricula(m);
    }

   
    @ApiOperation(value = "Get one matricula by id ", response = Matricula.class)
    @GetMapping("/{id}")
    Optional<Matricula> one(@PathVariable Long id) {
        return service.getMatriculaById(id);
    }

    @ApiOperation(value = "Replace one matricula by id", response = Matricula.class)
    @PutMapping("/{id}")
    Matricula replaceMatricula(@RequestBody Matricula newMatricula, @PathVariable Long id) {

        return service.getMatriculaById(id)
                .map(matricula -> {
                    matricula.setLibreta_uni_estudiante(newMatricula.getLibreta_uni_estudiante());
                    matricula.setId_carrera(newMatricula.getId_carrera());
                    matricula.setAntiguedad(newMatricula.getAntiguedad());
                    matricula.setAntiguedad(newMatricula.getAntiguedad());
                    matricula.setGraduado((newMatricula.isGraduado()));
                    matricula.setAnio_cursada((newMatricula.getAnio_cursada()));
                    return service.saveMatricula(matricula);
                })
                .orElseGet(() -> {
                    //newMatricula.setLibreta_uni_estudiante(id);
                    return service.saveMatricula(newMatricula);
                });
    }

    @ApiOperation(value = "Delete matricula by id", response = Carrera.class)
    @DeleteMapping("/{id}")
    void deleteMatricula(@PathVariable Long id) {
        service.deleteMatriculaById(id);
    }
}
