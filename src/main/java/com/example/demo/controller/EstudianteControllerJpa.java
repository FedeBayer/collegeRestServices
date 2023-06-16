package com.example.demo.controller;

import com.example.demo.model.Estudiante;
import com.example.demo.service.EstudianteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("estudiantes")
@Api(value = "EstudianteControllerJpa", description = "REST API Estudiante description")
public class EstudianteControllerJpa {

    @Qualifier("estudianteServiceImpl")
    @Autowired
    private final EstudianteService service;

    public EstudianteControllerJpa(@Qualifier("estudianteServiceImpl") EstudianteService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get list of estudiantes", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @GetMapping("")
    public Iterable<Estudiante> getEstudiantes() {
        return service.getAllEstudiantes();
    }

    @ApiOperation(value = "Get list of estudiantes by name ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @GetMapping("/OrderByApellido")
    public Iterable<Estudiante> getEstudiantesOrderByApellido() {
        return service.getEstudiantesOrderByApellido();
    }

    @ApiOperation(value = "Save a student", response = Estudiante.class)
    @PostMapping("")
    public Estudiante saveEstudiante(@RequestBody Estudiante e) {
        return service.saveEstudiante(e);
    }

    @ApiOperation(value = "Get list of estudiantes by genre ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @GetMapping("/genero/{genero}")
    public List<Estudiante> getEstudiantesByGenero(@PathVariable(value="genero") String genero) {
        return service.findAllByGenero(genero);
    }

    @ApiOperation(value = "Get list of estudiantes by career id and city name ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @GetMapping("/carrera/{idCarrera}/ciudad/{ciudad}")
    public List<Estudiante> getEstudiantesByCiudadAndCarrera(@PathVariable(value="idCarrera")
    	long idCarrera, @PathVariable(value="ciudad") String ciudad) {

        return service.findAllByCarreraByCiudad(idCarrera, ciudad);
    }

    @ApiOperation(value = "Get one student by id", response = Estudiante.class)
    @GetMapping("/{id}")
    Optional<Estudiante> one(@PathVariable long id) {
        return service.getEstudianteById(id);
    }

     @ApiOperation(value = "Replace one student by id", response = Estudiante.class)
    @PutMapping("/{id}")
    Estudiante replaceEstudiante(@RequestBody Estudiante newEstudiante, @PathVariable long id) {

        return service.getEstudianteById(id)
                .map(estudiante -> {
                    estudiante.setNombre(newEstudiante.getNombre());
                    estudiante.setApellido(newEstudiante.getApellido());
                    estudiante.setEdad(newEstudiante.getEdad());
                    estudiante.setGenero(newEstudiante.getGenero());
                    estudiante.setDocumento(newEstudiante.getDocumento());
                    estudiante.setCiudad(newEstudiante.getCiudad());
                    return service.saveEstudiante(estudiante);
                })
                .orElseGet(() -> {
                    newEstudiante.setLibreta_universitaria(id);
                    return service.saveEstudiante(newEstudiante);
                });
    }

    @ApiOperation(value = "Delete one student by id")
    @DeleteMapping("/{id}")
    void deleteEstudiante(@PathVariable long id) {
        service.deleteEstudianteById(id);
    }
}
