package com.literalura.literalura.service;

import com.literalura.literalura.model.LibroEntity;
import com.literalura.literalura.repository.LibroRepository;
import com.literalura.literalura.repository.AutorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public LibroEntity guardarLibro(LibroEntity libro) {
        return libroRepository.save(libro);
    }

    public List<LibroEntity> listarTodos() { return libroRepository.findAll(); }
    public List<LibroEntity> buscarPorTitulo(String titulo) { return libroRepository.findByTituloContainingIgnoreCase(titulo); }
    public List<LibroEntity> buscarPorIdioma(String idioma) { return libroRepository.findByIdioma(idioma); }

    public Map<String, Long> contarLibrosPorIdioma() {
        return libroRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(LibroEntity::getIdioma, Collectors.counting()));
    }
}
