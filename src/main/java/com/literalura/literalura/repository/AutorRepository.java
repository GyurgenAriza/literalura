package com.literalura.literalura.repository;


import com.literalura.literalura.model.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AutorRepository extends JpaRepository<AutorEntity, Long> {
    List<AutorEntity> findByAnioFallecimientoIsNullOrAnioFallecimientoGreaterThan(int anio);
}
