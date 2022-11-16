package es2.projeto.librarytree.repositories;

import es2.projeto.librarytree.models.GerenTitulos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GerenTitulosRepository extends JpaRepository <GerenTitulos, Long> {
    @Query(value = "SELECT * FROM livro l WHERE l.livro_stt = 1", nativeQuery = true)
    public List<GerenTitulos> find();

    @Query(value = "SELECT * FROM livro l WHERE l.livro_stt = 1 AND UPPER(l.titulo_livro) LIKE %:fil%", nativeQuery = true)
    public List<GerenTitulos> findAllWithFilter(@Param("fil") String fil);

    @Query(value = "SELECT * FROM livro l WHERE l.id_livro = id", nativeQuery = true)
    public List<GerenTitulos> findById(@Param("id")int id);

    
}
