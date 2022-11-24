package es2.projeto.librarytree.repositories;

import es2.projeto.librarytree.models.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
}