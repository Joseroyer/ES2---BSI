package es2.projeto.librarytree.repositories;

import es2.projeto.librarytree.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}