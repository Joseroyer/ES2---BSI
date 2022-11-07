package es2.projeto.librarytree.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import es2.projeto.librarytree.models.Bibliotecario;

public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {
    @Query(value="SELECT * FROM bibliotecario b WHERE b.bi_senha=senha",nativeQuery=true)
    public List<Bibliotecario> findAllWithFilter(@Param("senha") String senha);
}
