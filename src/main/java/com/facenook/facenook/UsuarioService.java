package com.facenook.facenook;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    // Fuente de datos en memoria (pauta: mínimo 3 registros)
    private final List<Usuario> usuarios = new ArrayList<>();

    public UsuarioService() {
        usuarios.add(new Usuario(1, "Cynthia", "cynthia@example.com"));
        usuarios.add(new Usuario(2, "Cristopher", "cristopher@example.com"));
        usuarios.add(new Usuario(3, "Admin", "admin@example.com"));
    }

    /** Devuelve todos los usuarios. */
    public List<Usuario> obtenerTodos() {
        return usuarios;
    }

    /** Devuelve un usuario por id o null si no existe. */
    public Usuario obtenerPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    // GET /usuarios/buscar?q=texto
    public List<Usuario> buscar(String q) {
        String term = q == null ? "" : q.trim().toLowerCase();
        List<Usuario> resultado = new ArrayList<>();

        for (Usuario u : usuarios) {
            if (u.getNombre().toLowerCase().contains(term) ||
                u.getCorreo().toLowerCase().contains(term)) {
                resultado.add(u);
            }
        }

        return resultado;
    }
}
