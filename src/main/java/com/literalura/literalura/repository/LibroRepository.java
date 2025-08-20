package com.literalura.literalura.repository;


import com.literalura.literalura.model.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LibroRepository extends JpaRepository<LibroEntity, Integer> {
    List<LibroEntity> findByTituloContainingIgnoreCase(String titulo);
    List<LibroEntity> findByIdioma(String idioma);
}
