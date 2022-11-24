package es2.projeto.librarytree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es2.projeto.librarytree.models.Exemplar;

public interface ExemplarRepository extends JpaRepository<Exemplar, Long>{
    @Query(value = "SELECT * FROM exemplares e INNER JOIN livro l ON e.livro_id_livro = l.id_livro WHERE UPPER(l.titulo_livro) LIKE %:filtro% OR UPPER(l.autor_livro) LIKE %:filtro%", nativeQuery = true)
    List<Exemplar> findExemplar(@Param("filtro") String filtro);
}
