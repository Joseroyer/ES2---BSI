package es2.projeto.librarytree.repositories;


import es2.projeto.librarytree.models.AutorLivro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorLivroRepository extends JpaRepository <AutorLivro, String> {
    
}
