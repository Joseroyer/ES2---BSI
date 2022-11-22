package es2.projeto.librarytree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es2.projeto.librarytree.models.Exemplar;

public interface ExemplarRepository extends JpaRepository<Exemplar, Long>{
    
}
