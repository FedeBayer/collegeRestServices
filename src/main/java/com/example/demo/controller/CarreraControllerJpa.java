package com.example.demo.controller;

import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.model.ReporteDTO;
import com.example.demo.service.CarreraService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("carreras")
@Api(value = "CarreraControllerJpa", description = "REST API Carrera description")
public class CarreraControllerJpa {

    @Qualifier("carreraServiceImpl")
    @Autowired
    private final CarreraService service;

    public CarreraControllerJpa(@Qualifier("carreraServiceImpl") CarreraService repository) {
        service = repository;
    }

    @GetMapping("")
    public Iterable<Carrera> getCarreras() {
        return service.getAllCarreras();
    }
    
    @GetMapping("/conInscriptos")
    public List<Carrera> getCarrerasConInscriptos() {
        return service.getCarrerasConInscriptos();
    }
    
    @GetMapping("/reporte")
    public List<ReporteDTO> getReporteDeCarreras() {
        return service.getReporteDeCarreras();
    }
/*
    @ApiOperation(value = "Get list of carreras by name ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @GetMapping("/ByName/{name}")
    public Iterable<Carrera> getCarrerasByName(@PathVariable String name) {
        return service.findAllByName(name);
    }*/

    @PostMapping("")
    public Carrera newCarrera(@RequestBody Carrera c) {
        return service.saveCarrera(c);
    }

    /*@ApiOperation(value = "Get specific Carrera in the System ", response = Carrera.class, tags = "getCarrera")
    @RequestMapping(value = "/{name}")
    public Carrera getCarrera(@PathVariable(value = "name") String name) {
        return service.findAllByName(name).get(0);
    }*/

    @GetMapping("/{id}")
    Optional<Carrera> one(@PathVariable Long id) {
        return service.getCarreraById(id);
    }

    @PutMapping("/{id}")
    Carrera replaceCarrera(@RequestBody Carrera newCarrera, @PathVariable Long id) {

        return service.getCarreraById(id)
                .map(carrera -> {
                    carrera.setNombre(newCarrera.getNombre());
                    carrera.setDuracion(newCarrera.getDuracion());
                    carrera.setCantEstudiantes(newCarrera.getCantEstudiantes());
                    return service.saveCarrera(carrera);
                })
                .orElseGet(() -> {
                    newCarrera.setId(id);
                    return service.saveCarrera(newCarrera);
                });
    }

    @DeleteMapping("/{id}")
    void deleteCarrera(@PathVariable Long id) {
        service.deleteCarreraById(id);
    }
}