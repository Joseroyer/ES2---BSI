package es2.projeto.librarytree.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es2.projeto.librarytree.models.Emprestimo;

public interface DevolucaoRepository extends JpaRepository<Emprestimo, Long>{

    @Query(value = "SELECT * FROM emprestimo e WHERE e.status = 0 ORDER BY id_emprestimo ASC", nativeQuery = true)
    List<Emprestimo> findExemplar();

    @Query(value = "SELECT * FROM emprestimo e WHERE e.forma_pagamento LIKE filtro ", nativeQuery = true)
    List<Emprestimo> findExemplarFiltro(@Param("filtro") String filtro);
    
}
