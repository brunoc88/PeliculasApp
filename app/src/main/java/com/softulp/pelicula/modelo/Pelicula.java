package com.softulp.pelicula.modelo;

public class Pelicula {
    private String titulo;
    private String descripcion;
    private int foto;
    private String director;
    private String []actores;

    public Pelicula(String titulo, String descripcion, int foto, String director, String[] actores) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.foto = foto;
        this.director = director;
        this.actores = actores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String[] getActores() {
        return actores;
    }

    public void setActores(String[] actores) {
        this.actores = actores;
    }
}
