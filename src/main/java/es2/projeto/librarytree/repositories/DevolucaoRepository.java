package es2.projeto.librarytree.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es2.projeto.librarytree.models.Emprestimo;

public interface DevolucaoRepository extends JpaRepository<Emprestimo, Long>{

    @Query(value = "SELECT * FROM emprestimo e WHERE e.status = 0 ORDER BY id_emprestimo ASC", nativeQuery = true)
    List<Emprestimo> findExemplar();

    @Query(value = "SELECT * FROM emprestimo e INNER JOIN cliente c ON e.cliente_id = c.cli_id INNER JOIN exemplares ex on e.exemplar_id = ex.id_exemplar INNER JOIN livro l on ex.livro_id_livro = l.id_livro WHERE UPPER(c.cli_nome) LIKE %:filtro% OR UPPER(l.titulo_livro) LIKE %:filtro%", nativeQuery = true)
    List<Emprestimo> findExemplarFiltro(@Param("filtro") String filtro);
    
}
