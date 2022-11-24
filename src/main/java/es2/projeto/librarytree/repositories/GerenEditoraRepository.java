package es2.projeto.librarytree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es2.projeto.librarytree.models.Editora;

public interface GerenEditoraRepository extends JpaRepository<Editora, Long> {
    @Query(value = "SELECT * FROM editora e WHERE e.status = 1 ORDER BY id_editora ASC", nativeQuery = true)
    public List<Editora> find();

    @Query(value = "SELECT * FROM editora e WHERE e.status = 1 AND (UPPER(e.nome_editora) LIKE %:fil% OR UPPER(e.cidade_editora) LIKE %:fil%) ORDER BY id_editora ASC", nativeQuery = true)
    public List<Editora> findAllWithFilter(@Param("fil") String fil);

    @Query(value = "SELECT * FROM editora e WHERE e.id_editora = id", nativeQuery = true)
    public List<Editora> findById(@Param("id") int id);
}
