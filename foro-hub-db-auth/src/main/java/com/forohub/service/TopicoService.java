package com.forohub.service;
import com.forohub.model.Topico;
import com.forohub.repository.TopicoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class TopicoService {
    private final TopicoRepository repo;
    public TopicoService(TopicoRepository repo){ this.repo = repo; }
    public List<Topico> listar(){ return repo.findAll(); }
    public Optional<Topico> obtener(Integer id){ return repo.findById(id); }
    public Topico guardar(Topico t){ return repo.save(t); }
    public void eliminar(Integer id){ repo.deleteById(id); }
}
