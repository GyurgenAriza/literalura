package com.literalura.literalura.model;


import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "libros")
public class LibroEntity {

    @Id
    private int id; // ID de la API

    private String titulo;
    private String idioma;
    private int numDescargas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private AutorEntity autor;

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    public int getNumDescargas() { return numDescargas; }
    public void setNumDescargas(int numDescargas) { this.numDescargas = numDescargas; }
    public AutorEntity getAutor() { return autor; }
    public void setAutor(AutorEntity autor) { this.autor = autor; }

    @Override
    public String toString() {
        return titulo + " | " + (autor != null ? autor.getNombre() : "Desconocido") +
                " | Idioma: " + idioma + " | Descargas: " + numDescargas;
    }

    @Override
    public boolean equals(Object o) { /* estándar */ return true; }
    @Override
    public int hashCode() { return Objects.hash(id); }
}




