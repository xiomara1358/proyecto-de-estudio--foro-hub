package com.forohub.controller;
import com.forohub.model.Curso;
import com.forohub.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    private final CursoService service;
    public CursoController(CursoService service){ this.service = service; }
    @GetMapping public List<Curso> listar(){ return service.listar(); }
    @GetMapping("/{id}") public ResponseEntity<Curso> obtener(@PathVariable Integer id){
        return service.obtener(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public Curso crear(@RequestBody Curso c){ return service.guardar(c); }
    @PutMapping("/{id}") public ResponseEntity<Curso> actualizar(@PathVariable Integer id, @RequestBody Curso c){
        return service.obtener(id).map(ex -> { ex.setNombre(c.getNombre()); ex.setCategoria(c.getCategoria()); return ResponseEntity.ok(service.guardar(ex)); }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        return service.obtener(id).map(ex -> { service.eliminar(id); return ResponseEntity.noContent().build(); }).orElse(ResponseEntity.notFound().build());
    }
}
