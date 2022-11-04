package es2.projeto.librarytree.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface indexRepository extends JpaRepository {

    // @Query(value="SELECT * FROM usuario u WHERE u.senha=senha",nativeQuery=true)
    //public List<Usuario> findAllWithFilter(@Param("senha") String senha);
    
}
