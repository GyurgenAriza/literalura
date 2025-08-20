package com.literalura.literalura.service;


import com.literalura.literalura.model.AutorEntity;
import com.literalura.literalura.repository.AutorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) { this.autorRepository = autorRepository; }

    public List<AutorEntity> listarAutores() { return autorRepository.findAll(); }

    public List<AutorEntity> listarAutoresVivosEnAnio(int anio) {
        return autorRepository.findByAnioFallecimientoIsNullOrAnioFallecimientoGreaterThan(anio);
    }
}
