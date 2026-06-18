package com.portfolio.biblioteca.controller;

import com.portfolio.biblioteca.dto.LivroDTO;
import com.portfolio.biblioteca.model.Livro;
import com.portfolio.biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200") // Permite que o Angular (porta 4200) aceda à API
public class LivroController {

    private final LivroService service;
    private final LivroService livroService;

    @GetMapping
    public List<LivroDTO> listar() {
        return service.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroDTO criar(@RequestBody LivroDTO dto) {
        return service.salvar(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build(); // retorna o status 204 (No content), que é o padrão correto para as deleções com sucesso.
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Livro> alternarStatusLido(@PathVariable Long id) {
        Livro livroAtualizado = livroService.alternarStatusLido(id);
        return ResponseEntity.ok(livroAtualizado); // retorna o livro já modificado
    }
}