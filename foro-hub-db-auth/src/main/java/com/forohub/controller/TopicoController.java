package com.forohub.controller;
import com.forohub.model.Topico;
import com.forohub.service.TopicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/topicos")
public class TopicoController {
    private final TopicoService service;
    public TopicoController(TopicoService service){ this.service = service; }
    @GetMapping public List<Topico> listar(){ return service.listar(); }
    @GetMapping("/{id}") public ResponseEntity<Topico> obtener(@PathVariable Integer id){
        return service.obtener(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public Topico crear(@RequestBody Topico t){ return service.guardar(t); }
    @PutMapping("/{id}") public ResponseEntity<Topico> actualizar(@PathVariable Integer id, @RequestBody Topico t){
        return service.obtener(id).map(ex -> { ex.setTitulo(t.getTitulo()); ex.setMensaje(t.getMensaje()); ex.setStatus(t.getStatus()); ex.setCurso(t.getCurso()); ex.setAutor(t.getAutor()); return ResponseEntity.ok(service.guardar(ex)); }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        return service.obtener(id).map(ex -> { service.eliminar(id); return ResponseEntity.noContent().build(); }).orElse(ResponseEntity.notFound().build());
    }
}
