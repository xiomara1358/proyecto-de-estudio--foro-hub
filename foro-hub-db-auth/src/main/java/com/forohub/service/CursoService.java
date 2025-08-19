package com.forohub.service;
import com.forohub.model.Curso;
import com.forohub.repository.CursoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CursoService {
    private final CursoRepository repo;
    public CursoService(CursoRepository repo){ this.repo = repo; }
    public List<Curso> listar(){ return repo.findAll(); }
    public Optional<Curso> obtener(Integer id){ return repo.findById(id); }
    public Curso guardar(Curso c){ return repo.save(c); }
    public void eliminar(Integer id){ repo.deleteById(id); }
}
