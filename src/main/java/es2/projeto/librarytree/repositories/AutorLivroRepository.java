package es2.projeto.librarytree.repositories;


import es2.projeto.librarytree.models.AutorLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AutorLivroRepository extends JpaRepository <AutorLivro, String> {
    @Query(value = "SELECT * FROM livro l WHERE l.livro_status = 1", nativeQuery = true)
    public List<Titulos> find();

}
