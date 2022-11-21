package es2.projeto.librarytree.repositories;

import es2.projeto.librarytree.models.Emprestimo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
   
}
