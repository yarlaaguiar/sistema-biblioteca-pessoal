package com.portfolio.biblioteca.service;

import com.portfolio.biblioteca.dto.LivroDTO;
import com.portfolio.biblioteca.model.Livro;
import com.portfolio.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository repository;

    public List<LivroDTO> listarTodos() {
        return repository.findAll().stream().map(livro -> new LivroDTO(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getIsbn(),
                livro.isLido()
        ))
                .toList();
    }

    public LivroDTO salvar(LivroDTO dto) {
        Livro livro = new Livro();
        livro.setTitulo(dto.titulo());
        livro.setAutor(dto.autor());
        livro.setIsbn(dto.isbn());
        livro.setLido(dto.lido());

        Livro livroSalvo = repository.save(livro);

        return new LivroDTO(
                livroSalvo.getId(),
                livroSalvo.getTitulo(),
                livroSalvo.getAutor(),
                livroSalvo.getIsbn(),
                livroSalvo.isLido()
        );
    }
}
