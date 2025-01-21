package com.foro.alura.foro.repository;

import com.foro.alura.foro.modelo.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicosRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findByEstadoTopicoTrue(Pageable paginacion);
}
