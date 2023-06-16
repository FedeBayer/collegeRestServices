package com.example.demo.service;

import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.model.ReporteDTO;
import com.example.demo.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarreraServiceImpl implements CarreraService {
    private CarreraRepository repository;

    @Autowired
    public CarreraServiceImpl(CarreraRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Carrera> getAllCarreras() {
        return repository.findAll();
    }

    @Override
    public Carrera saveCarrera(Carrera c) {
        return repository.save(c);
    }

    @Override
    public Optional<Carrera> getCarreraById(long id) {
        return Optional.of(repository.getOne(id));
    }

    @Override
    public Carrera replaceCarrera(Carrera c, long id) {
        return repository.findById(id)
                .map(carrera -> {
                    carrera.setNombre(c.getNombre());
                    carrera.setDuracion(c.getDuracion());
                    carrera.setCantEstudiantes(c.getCantEstudiantes());
                    return repository.save(carrera);
                })
                .orElseGet(() -> {
                    c.setId(id);
                    return repository.save(c);
                });
    }

    @Override
    public void deleteCarreraById(long id) {
        repository.deleteById(id);
    }

	@Override
	public List<Carrera> getCarrerasConInscriptos() {
		return repository.findAllWithEstudiantes();
	}

	@Override
	public List<ReporteDTO> getReporteDeCarreras() {
        List<Object[]> reportes = repository.generarReporte();
        List<ReporteDTO> reporte = reportes.stream()
                .map(o -> new ReporteDTO((String) o[0], (int) o[1], (int) o[2], (BigInteger) o[3]))
                .collect(Collectors.toList());
        return reporte;
	}
}
