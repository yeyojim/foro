package com.foro.alura.foro.controller;

import com.foro.alura.foro.modelo.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.foro.alura.foro.repository.TopicosRepository;

import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/topicos")
public class TopicoController {


    @Autowired
    private TopicosRepository repository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @PostMapping
    public ResponseEntity<RespuestTopicos> createPost(@RequestBody @Valid PeticionTopicos peticionTopicos) {
        Topico topico = repository.save(new Topico(peticionTopicos));
        RespuestTopicos respuestTopicos = new RespuestTopicos(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion().format(formatter));

        return ResponseEntity.ok(respuestTopicos);

    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> listaTopicos(@PageableDefault(size = 10) Pageable paginacion) {

        return ResponseEntity.ok(repository.findByEstadoTopicoTrue(paginacion).map(DatosListadoTopicos::new));

    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestTopicos> retornaDatosMedico(@PathVariable Long id) {
        Topico topico = repository.getReferenceById(id);
        var datosTopicos = new RespuestTopicos(topico.getId(), topico.getTitulo(),
                topico.getMensaje(), topico.getFechaCreacion().format(formatter));
        return ResponseEntity.ok(datosTopicos);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid ActualizarTopico actualizarTopico) {
        Topico topico = repository.getReferenceById(actualizarTopico.id());
        topico.actualizarDatos(actualizarTopico);
        return ResponseEntity.ok(new RespuestTopicos(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion().format(formatter)
        ));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = repository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();

    }
}








