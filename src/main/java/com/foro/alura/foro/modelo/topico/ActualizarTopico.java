package com.foro.alura.foro.modelo.topico;

import jakarta.validation.constraints.NotNull;

public record ActualizarTopico(

@NotNull
Long id,
String mensaje,
String nombreCurso,
String titulo,
String autor
) {
}
