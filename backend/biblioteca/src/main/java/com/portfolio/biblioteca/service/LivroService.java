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
    private final LivroRepository livroRepository;

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
    public void deletarLivro(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new RuntimeException("Livro não encontrado com o ID: " + id);
        }
        livroRepository.deleteById(id);
    }
    public Livro alternarStatusLido(Long id) {
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado com o ID: " + id));
        // Inverte o estado atual do livro (se estava lido, passa a não lido, e vice-versa)
        livro.setLido(!livro.isLido());
        return livroRepository.save(livro);
    }
}
