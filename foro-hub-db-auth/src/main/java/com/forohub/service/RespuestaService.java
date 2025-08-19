package com.forohub.service;
import com.forohub.model.Respuesta;
import com.forohub.repository.RespuestaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class RespuestaService {
    private final RespuestaRepository repo;
    public RespuestaService(RespuestaRepository repo){ this.repo = repo; }
    public List<Respuesta> listar(){ return repo.findAll(); }
    public Optional<Respuesta> obtener(Integer id){ return repo.findById(id); }
    public Respuesta guardar(Respuesta r){ return repo.save(r); }
    public void eliminar(Integer id){ repo.deleteById(id); }
}
