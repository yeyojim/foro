package com.foro.alura.foro.modelo.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;



@AllArgsConstructor
@Entity
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String idusuario;

    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private String nombreCurso;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private Boolean estadoTopico = true;

    @Column(nullable = false)
    private String autor;

    public Topico() {
    }

    public Topico(@Valid PeticionTopicos peticionTopicos) {

        this.idusuario = peticionTopicos.idusuario();
        this.mensaje = peticionTopicos.mensaje();
        this.nombreCurso = peticionTopicos.nombreCurso();
        this.titulo = peticionTopicos.titulo();
        this.autor = peticionTopicos.autor();

    }

    public Long getId() {
        return id;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Boolean getEstadoTopico() {
        return estadoTopico;
    }

    public String getAutor() {
        return autor;
    }

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }

    public void actualizarDatos(@Valid ActualizarTopico actualizarTopico) {
        if (actualizarTopico.autor() != null) {
            this.autor = actualizarTopico.autor();

        }

        if (actualizarTopico.mensaje() != null) {
            this.mensaje = actualizarTopico.mensaje();
        }

        if (actualizarTopico.nombreCurso() != null) {
            this.nombreCurso = actualizarTopico.nombreCurso();

        }
        if (actualizarTopico.titulo() != null) {
            this.titulo = actualizarTopico.titulo();

        }

    }

    public void desactivarTopico() {
        this.estadoTopico=false;
    }
}
