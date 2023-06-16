package com.example.demo.service;

import com.example.demo.model.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    private EstudianteRepository repository;

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Estudiante> getAllEstudiantes() {
        return repository.findAll();
    }

    @Override
    public List<Estudiante> getEstudiantesOrderByApellido() {
        return repository.findAllOrderByApellido();
    }

    @Override
    public Estudiante saveEstudiante(Estudiante e) {
        return repository.save(e);
    }

    @Override
    public Optional<Estudiante> getEstudianteById(long id) {
    	// Antes usaba getOne(id) pero daba error
        return Optional.of(repository.findById(id).get());
    }

    @Override
    public Estudiante replaceEstudiante(Estudiante e, long id) {
        return repository.findById(id)
                .map(estudiante -> {
                    estudiante.setNombre(e.getNombre());
                    estudiante.setApellido(e.getApellido());
                    estudiante.setEdad(e.getEdad());
                    estudiante.setGenero(e.getGenero());
                    estudiante.setDocumento(e.getDocumento());
                    estudiante.setCiudad(e.getCiudad());
                    return repository.save(estudiante);
                })
                .orElseGet(() -> {
                    e.setLibreta_universitaria(id);
                    return repository.save(e);
                });
    }

    @Override
    public void deleteEstudianteById(long id) {
        repository.deleteById(id);
    }

	@Override
	public List<Estudiante> findAllByGenero(String genero) {
		return repository.findAllByGenero(genero);
	}

	@Override
	public List<Estudiante> findAllByCarreraByCiudad(long idCarrera, String ciudad) {
		return repository.findAllByCarreraByCiudad(idCarrera, ciudad);
	}
}
