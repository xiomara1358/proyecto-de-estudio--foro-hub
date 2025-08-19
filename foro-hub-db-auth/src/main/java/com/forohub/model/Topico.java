package com.forohub.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "topico")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Topico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String mensaje;

    private LocalDateTime fechaCreacion;

    private String status;

    @ManyToOne @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;

    @PrePersist
    public void prePersist() {
        if (this.fechaCreacion == null) this.fechaCreacion = LocalDateTime.now();
        if (this.status == null) this.status = "ABIERTO";
    }
}
