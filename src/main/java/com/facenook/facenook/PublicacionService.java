package com.facenook.facenook;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PublicacionService {

    private final List<Publicacion> publicaciones = new ArrayList<>();

     public PublicacionService(UsuarioService usuarioService) {
        //USUARIOS CREADOS EN USUARIOSERVICE
        Usuario cynthia = usuarioService.obtenerPorId(1);
        Usuario cristopher = usuarioService.obtenerPorId(2);
        Usuario admin = usuarioService.obtenerPorId(3);

        //PRIMERA PUBLICACIÓN
        Publicacion p1 = new Publicacion(1,cynthia,"Conejito","¿Cómo están? ¿Que calificacion le dan a este conejito?",LocalDate.now().minusDays(2));
        Publicacion p2 = new Publicacion(2,cristopher,"¡Extremo!","¡Admiren el movimiento de hoy! ¿Calificación?",LocalDate.now().minusDays(2));
        Publicacion p3 = new Publicacion(2,admin,"¡Ser admin!","¿Que calificación me dan como admin?",LocalDate.now().minusDays(2));

        p1.getImagenes().add("/img/conejo_1.jpg");
        p1.getComentarios().add(new Comentario(101, cristopher, "Un 5", LocalDate.now().minusDays(2)));
        p1.getComentarios().add(new Comentario(102, admin, "Un 4", LocalDate.now()));
        p1.getCalificaciones().add(new Calificacion(201, cristopher, 5, LocalDate.now().minusDays(2)));
        p1.getCalificaciones().add(new Calificacion(202, admin, 4, LocalDate.now().minusDays(2)));

        p2.getImagenes().add("/img/conejo_1.jpg");
        p2.getComentarios().add(new Comentario(103, cynthia, "¡Increible! ¡Un 5!", LocalDate.now().minusDays(2)));
        p2.getComentarios().add(new Comentario(104, admin, "Naah, un 2", LocalDate.now()));
        p2.getCalificaciones().add(new Calificacion(203, cynthia, 5, LocalDate.now().minusDays(2)));
        p2.getCalificaciones().add(new Calificacion(204, admin, 2, LocalDate.now().minusDays(2)));

        p2.getImagenes().add("/img/conejo_1.jpg");
        p2.getComentarios().add(new Comentario(105, cynthia, "¡Un 5!", LocalDate.now().minusDays(2)));
        p2.getComentarios().add(new Comentario(106, cristopher, "¡Es mi venganza sparky! 2", LocalDate.now()));
        p2.getCalificaciones().add(new Calificacion(205, cynthia, 5, LocalDate.now().minusDays(2)));
        p2.getCalificaciones().add(new Calificacion(206, cristopher, 2, LocalDate.now().minusDays(2)));

        publicaciones.add(p1);
        publicaciones.add(p2);
        publicaciones.add(p3);
    }

    // OBTENGO TODAS LAS PUBLICACIONES
    public List<Publicacion> obtenerTodas() {
        return publicaciones;
    }

    // OBTENGO LAS PUBLICACIONES POR ID
    public Publicacion obtenerPorId(int id) {
        for (Publicacion p : publicaciones) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    // OBTENGO LOS COMENTARIOS POR EL ID DE LA PUBLICACIÓN
    public List<Comentario> obtenerComentarios(int idPublicacion) {
        Publicacion p = obtenerPorId(idPublicacion);
        return (p != null) ? p.getComentarios() : new ArrayList<>();
    }

    // OBTENGO LAS CALIFICACIONES POR EL ID DE LA PUBLICACIÓN
    public List<Calificacion> obtenerCalificaciones(int idPublicacion) {
        Publicacion p = obtenerPorId(idPublicacion);
        return (p != null) ? p.getCalificaciones() : new ArrayList<>();
    }

    //OBTENGO EL PROMEDIO DE CALIFICACIONES
    public double obtenerPromedioCalificaciones(int idPublicacion) {
        List<Calificacion> calificaciones = obtenerCalificaciones(idPublicacion);
        if (calificaciones.isEmpty()) {
            return 0.0;
        }
        double suma = 0;
        for (Calificacion calificacion : calificaciones) {
            suma += calificacion.getValor();
        }
        return suma / calificaciones.size();
    }

}
