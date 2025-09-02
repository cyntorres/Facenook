package com.facenook.facenook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private int id;
    private Usuario usuario;
    private String titulo; 
    private String contenido;
    private List<String> imagenes = new ArrayList<>();
    private List<Comentario> comentarios = new ArrayList<>();
    private List<Calificacion> calificaciones = new ArrayList<>();
    private LocalDate fecha;

    public Publicacion(int id, Usuario usuario, String titulo, String contenido, LocalDate fecha) {
        this.id = id;
        this.usuario = usuario;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public int getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public String getTitulo() { return titulo; }
    public String getContenido() { return contenido; }
    public List<Calificacion> getCalificaciones() { return calificaciones; }
    public List<Comentario> getComentarios() { return comentarios; }
    public LocalDate getFecha() { return fecha; }
    public List<String> getImagenes() { return imagenes; }
}