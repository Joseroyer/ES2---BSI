package es2.projeto.librarytree.repositories;

import es2.projeto.librarytree.models.Exemplares;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplaresRepository extends JpaRepository<Exemplares, Long> {
}