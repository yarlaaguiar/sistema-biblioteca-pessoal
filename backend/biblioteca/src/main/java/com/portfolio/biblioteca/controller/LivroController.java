package com.portfolio.biblioteca.controller;

import com.portfolio.biblioteca.dto.LivroDTO;
import com.portfolio.biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200") // Permite que o Angular (porta 4200) aceda à API
public class LivroController {

    private final LivroService service;

    @GetMapping
    public List<LivroDTO> listar() {
        return service.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroDTO criar(@RequestBody LivroDTO dto) {
        return service.salvar(dto);
    }
}