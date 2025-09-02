package com.facenook.facenook;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // GET /usuarios
    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    // GET /usuarios/{id}
    @GetMapping("/{id}")
    public Usuario obtenerPorId(@PathVariable int id) {
        return usuarioService.obtenerPorId(id);
    }

    // GET /usuarios/buscar?q=texto
    @GetMapping("/buscar")
    public List<Usuario> buscar(@RequestParam String q) {
        return usuarioService.buscar(q);
    }
}
