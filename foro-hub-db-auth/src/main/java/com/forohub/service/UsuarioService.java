package com.forohub.service;
import com.forohub.model.Usuario;
import com.forohub.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    public UsuarioService(UsuarioRepository repo){ this.repo = repo; }
    public List<Usuario> listar(){ return repo.findAll(); }
    public Optional<Usuario> obtener(Integer id){ return repo.findById(id); }
    public Usuario guardar(Usuario u){ return repo.save(u); }
    public void eliminar(Integer id){ repo.deleteById(id); }
}
