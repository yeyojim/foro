package com.foro.alura.foro.modelo.topico;

import jakarta.validation.constraints.NotBlank;

public record PeticionTopicos(@NotBlank String idusuario,
                              @NotBlank String mensaje,
                              @NotBlank String nombreCurso,
                              @NotBlank String titulo,
                              @NotBlank String autor) {
}
