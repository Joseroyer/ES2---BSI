package es2.projeto.librarytree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import es2.projeto.librarytree.models.Parametrizacao;

public interface ParametrizacaoRepository extends JpaRepository<Parametrizacao, Long> {
    
    @Query(value="SELECT * from parametrizacao",nativeQuery=true)
        public List<Parametrizacao> findAll();
    @Query(value="UPDATE parametrizacao p set p.nome_empresa='Nome', p.logotipo=1 WHERE p.id=id",nativeQuery=true)
        public List<Parametrizacao> Update(@Param("id")long id);


}
