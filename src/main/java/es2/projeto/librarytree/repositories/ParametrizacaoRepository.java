package es2.projeto.librarytree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.*;

import es2.projeto.librarytree.models.Parametrizacao;

public interface ParametrizacaoRepository extends JpaRepository<Parametrizacao, Long> {
    
    @Query(value="SELECT * from parametrizacao",nativeQuery=true)
        public List<Parametrizacao> findAll();


}
