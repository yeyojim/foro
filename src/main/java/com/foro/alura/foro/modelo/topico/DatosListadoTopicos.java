package com.foro.alura.foro.modelo.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosListadoTopicos(

        @NotBlank String idusuario,
        @NotBlank String mensaje,
        @NotBlank String nombreCurso,
        @NotBlank String titulo,
        @NotBlank String autor
) {

    public DatosListadoTopicos(Topico topico) {

this(topico.getIdusuario(), topico.getMensaje(), topico.getNombreCurso(), topico.getTitulo(), topico.getAutor());
    }
}
