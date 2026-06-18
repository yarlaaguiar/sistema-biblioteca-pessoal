package com.portfolio.biblioteca.config;

import com.portfolio.biblioteca.model.Livro;
import com.portfolio.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DadosIniciaisConfig implements CommandLineRunner {

    private final LivroRepository repository;

    @Override
    public void run(String... args) throws Exception {
        // Se o banco estiver vazio, adiciona livros de teste
        if (repository.count() == 0) {
            Livro livro1 = new Livro();
            livro1.setTitulo("O Senhor dos Anéis");
            livro1.setAutor("J.R.R. Tolkien");
            livro1.setIsbn("9788595086357");
            livro1.setLido(true);

            Livro livro2 = new Livro();
            livro2.setTitulo("Código Limpo (Clean Code)");
            livro2.setAutor("Robert C. Martin");
            livro2.setIsbn("9788576082675");
            livro2.setLido(false);

            repository.save(livro1);
            repository.save(livro2);

            System.out.println("📚 Livros de teste inseridos com sucesso!");
        }
    }
}