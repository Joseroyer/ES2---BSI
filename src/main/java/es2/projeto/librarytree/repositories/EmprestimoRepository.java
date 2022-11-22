package es2.projeto.librarytree.repositories;

import es2.projeto.librarytree.models.Emprestimo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
   
}
