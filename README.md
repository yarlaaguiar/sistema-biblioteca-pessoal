# 📚 Sistema de Gestão de Biblioteca Pessoal

Um sistema Full-Stack moderno desenvolvido para o gerenciamento de uma biblioteca pessoal de livros. O projeto foi construído dividindo as responsabilidades de forma clara entre um ecossistema robusto no Backend e uma interface reativa e de alta performance no Frontend.

---

## 🛠️ Tecnologias e Conceitos Aplicados

### ☕ Backend (Java & Spring Boot)
- **Spring Boot 3.x:** Configuração ágil e ambiente robusto para a API REST.
- **Spring Data JPA:** Abstração completa da camada de persistência de dados.
- **H2 Database:** Banco de dados relacional em memória, ideal para portfólios (não exige instalação local do avaliador).
- **Lombok:** Otimização de código através da geração automática de Boilerplate (Getters, Setters, Construtores).
- **Arquitetura em Camadas:** Separação estrita de responsabilidades utilizando os padrões `Model`, `DTO (Data Transfer Object)`, `Repository`, `Service` e `Controller`.
- **CORS Configuration:** Implementação de segurança para comunicação cross-origin.

### 🅰️ Frontend (Angular Moderno)
- **Componentes Standalone:** Arquitetura limpa e independente, eliminando a necessidade de NgModules tradicionais.
- **Angular Signals:** Gestão de estado moderna, reativa e síncrona para atualizações precisas na interface.
- **Zoneless Mode:** Configuração nativa sem a dependência do `Zone.js`, garantindo performance máxima e menor tamanho de bundle.
- **Reactive Forms:** Captura e validação robusta de dados inseridos pelo utilizador.
- **Nova Sintaxe de Fluxo (`@for`, `@if`, `@empty`):** Renderização nativa e otimizada de listas e condicionais no HTML.

---

## 🚀 Como Executar o Projeto Localmente

### Pré-requisitos
- Java 17 ou superior instalado
- Node.js e Angular CLI instalados

### 1. Executando o Backend
1. Abra a pasta `backend` na sua IDE (IntelliJ IDEA ou Eclipse).
2. Aguarde o download das dependências do Maven.
3. Execute a classe principal `BibliotecaApplication.java`.
4. O servidor iniciará na porta `8080`. Você pode verificar a API em: `http://localhost:8080/api/livros`.

### 2. Executando o Frontend
1. No terminal, aceda à pasta `frontend`.
2. Instale as dependências com: `npm install`.
3. Inicie o servidor de desenvolvimento com: `ng serve`.
4. Abra o navegador em: `http://localhost:4200`.

---

## 🔮 Próximos Passos (Roadmap)
- [ ] Implementar a funcionalidade de atualizar o status do livro (Lido / Não Lido).
- [ ] Adicionar botão para Eliminar/Excluir um livro da lista.
- [ ] Integração com uma API externa (ex: Google Books API) para autopreencher os dados através do ISBN.
- [ ] Implementar testes unitários com JUnit (Backend) e Jasmine/Jest (Frontend).
