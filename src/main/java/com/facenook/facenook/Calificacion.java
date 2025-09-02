package com.facenook.facenook;
import java.time.LocalDate;

public class Calificacion {
    private int id;
    private Usuario usuario;
    private int valor;
    private LocalDate fecha;

    public Calificacion(int id, Usuario usuario, int valor, LocalDate fecha) {
        this.id = id;
        this.usuario = usuario;
        this.valor = valor;
        this.fecha = fecha;
    }

    public int getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public int getValor() { return valor; }
    public LocalDate getFecha() { return fecha; }
}

