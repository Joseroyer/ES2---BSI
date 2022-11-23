package es2.projeto.librarytree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es2.projeto.librarytree.models.Emprestimo;
import es2.projeto.librarytree.models.EmprestimoExemplar;

public interface DevolucaoRepository extends JpaRepository<Emprestimo, Integer>{
    @Query(value="SELECT * from emprestimoexemplar",nativeQuery=true)
        public List<EmprestimoExemplar> findExemplares();
    
}
