package es2.projeto.librarytree.repositories;

import es2.projeto.librarytree.models.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {
}
