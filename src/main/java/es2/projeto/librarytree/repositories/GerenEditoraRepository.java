package es2.projeto.librarytree.repositories;

import es2.projeto.librarytree.models.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GerenEditoraRepository extends JpaRepository<Editora, Long> {
    @Query(value = "SELECT * FROM editora e WHERE e.status = 1", nativeQuery = true)
    public List<Editora> find();

    @Query(value = "SELECT * FROM editora e WHERE e.status = 1 AND UPPER(e.nome_editora) LIKE %:fil%", nativeQuery = true)
    public List<Editora> findAllWithFilter(@Param("fil") String fil);

    @Query(value = "SELECT * FROM editora e WHERE e.id_editora = id", nativeQuery = true)
    public List<Editora> findById(@Param("id")int id);
}

