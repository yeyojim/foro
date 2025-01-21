CREATE TABLE topicos (
    id BIGSERIAL PRIMARY KEY,
    idusuario VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    nombre_curso VARCHAR(255) NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    estado_topico BOOLEAN DEFAULT FALSE,
    autor VARCHAR(255) NOT NULL
);