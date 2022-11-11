package es2.projeto.librarytree.repositories;

import es2.projeto.librarytree.models.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {
    @Query(value = "SELECT * FROM bibliotecario b WHERE b.bi_senha=:senha and b.bi_login=:login", nativeQuery = true)
    public List<Bibliotecario> findFilterWith(@Param("senha") String senha, @Param("login") String login);
}
