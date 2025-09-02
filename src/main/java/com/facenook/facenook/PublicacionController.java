package com.facenook.facenook;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

    private final PublicacionService publicacionService;

    public PublicacionController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    // GET /publicaciones
    @GetMapping
    public List<Publicacion> obtenerTodas() {
        return publicacionService.obtenerTodas();
    }

    // GET /publicaciones/{id}
    @GetMapping("/{id}")
    public Publicacion obtenerPorId(@PathVariable int id) {
        return publicacionService.obtenerPorId(id);
    }

    // GET /publicaciones/{id}/comentarios
    @GetMapping("/{id}/comentarios")
    public List<Comentario> obtenerComentarios(@PathVariable int id) {
        return publicacionService.obtenerComentarios(id);
    }

    // GET /publicaciones/{id}/calificaciones
    @GetMapping("/{id}/calificaciones")
    public List<Calificacion> obtenerCalificaciones(@PathVariable int id) {
        return publicacionService.obtenerCalificaciones(id);
    }

    // GET /publicaciones/{id}/promedio
    @GetMapping("/{id}/promedio")
    public double obtenerPromedio(@PathVariable int id) {
        return publicacionService.obtenerPromedioCalificaciones(id);
    }
}