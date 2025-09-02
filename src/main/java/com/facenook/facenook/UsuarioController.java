package com.facenook.facenook;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Inyección por constructor (recomendada)
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // GET /usuarios -> lista todos
    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    // GET /usuarios/{id} -> devuelve un usuario específico
    @GetMapping("/{id}")
    public Usuario obtenerPorId(@PathVariable int id) {
        return usuarioService.obtenerPorId(id);
    }

    // GET /usuarios/buscar?q=texto -> búsqueda por nombre o correo
    @GetMapping("/buscar")
    public List<Usuario> buscar(@RequestParam String q) {
        return usuarioService.buscar(q);
    }
}
