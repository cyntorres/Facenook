package com.facenook.facenook;
import java.time.LocalDate;

public class Comentario {
    private int id;
    private Usuario usuario;
    private String texto;
    private LocalDate fecha;

    public Comentario(int id, Usuario usuario, String texto, LocalDate fecha) {
        this.id = id;
        this.usuario = usuario;
        this.texto = texto;
        this.fecha = fecha;
    }

    public int getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public String getTexto() { return texto;}
    public LocalDate getFecha() { return fecha;}
    
}
