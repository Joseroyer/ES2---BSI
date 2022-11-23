package es2.projeto.librarytree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es2.projeto.librarytree.models.Exemplares;

public interface ExemplaresRepository extends JpaRepository<Exemplares, Long> {

    @Query(value = "SELECT * FROM exemplares WHERE status = 1 ORDER BY id_exemplar ASC", nativeQuery = true)
    public List<Exemplares> findAllExemplar();

    @Query(value = "SELECT * FROM exemplares WHERE id_exemplar = :id", nativeQuery = true)
    public List<Exemplares> findById(@Param("id") int id);

}