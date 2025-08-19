package com.forohub.controller;
import com.forohub.model.Respuesta;
import com.forohub.service.RespuestaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {
    private final RespuestaService service;
    public RespuestaController(RespuestaService service){ this.service = service; }
    @GetMapping public List<Respuesta> listar(){ return service.listar(); }
    @GetMapping("/{id}") public ResponseEntity<Respuesta> obtener(@PathVariable Integer id){
        return service.obtener(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public Respuesta crear(@RequestBody Respuesta r){ return service.guardar(r); }
    @PutMapping("/{id}") public ResponseEntity<Respuesta> actualizar(@PathVariable Integer id, @RequestBody Respuesta r){
        return service.obtener(id).map(ex -> { ex.setMensaje(r.getMensaje()); ex.setSolucion(r.getSolucion()); ex.setAutor(r.getAutor()); ex.setTopico(r.getTopico()); return ResponseEntity.ok(service.guardar(ex)); }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        return service.obtener(id).map(ex -> { service.eliminar(id); return ResponseEntity.noContent().build(); }).orElse(ResponseEntity.notFound().build());
    }
}
