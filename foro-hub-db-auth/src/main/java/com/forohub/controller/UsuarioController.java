package com.forohub.controller;
import com.forohub.model.Usuario;
import com.forohub.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService service;
    public UsuarioController(UsuarioService service){ this.service = service; }
    @GetMapping public List<Usuario> listar(){ return service.listar(); }
    @GetMapping("/{id}") public ResponseEntity<Usuario> obtener(@PathVariable Integer id){
        return service.obtener(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public Usuario crear(@RequestBody Usuario u){ return service.guardar(u); }
    @PutMapping("/{id}") public ResponseEntity<Usuario> actualizar(@PathVariable Integer id, @RequestBody Usuario u){
        return service.obtener(id).map(ex -> { ex.setNombre(u.getNombre()); ex.setCorreoElectronico(u.getCorreoElectronico()); ex.setContrasena(u.getContrasena()); ex.setPerfiles(u.getPerfiles()); return ResponseEntity.ok(service.guardar(ex)); }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        return service.obtener(id).map(ex -> { service.eliminar(id); return ResponseEntity.noContent().build(); }).orElse(ResponseEntity.notFound().build());
    }
}
