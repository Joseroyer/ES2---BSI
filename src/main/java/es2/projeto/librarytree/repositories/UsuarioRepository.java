package es2.projeto.librarytree.repositories;

import es2.projeto.librarytree.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
