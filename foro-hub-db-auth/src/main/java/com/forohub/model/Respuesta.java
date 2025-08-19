package com.forohub.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "respuesta")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Respuesta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String mensaje;

    private LocalDateTime fechaCreacion;

    private Boolean solucion;

    @ManyToOne @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne @JoinColumn(name = "topico_id")
    private Topico topico;

    @PrePersist
    public void prePersist() {
        if (this.fechaCreacion == null) this.fechaCreacion = LocalDateTime.now();
        if (this.solucion == null) this.solucion = false;
    }
}
