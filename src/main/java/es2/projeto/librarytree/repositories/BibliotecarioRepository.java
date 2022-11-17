package es2.projeto.librarytree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es2.projeto.librarytree.models.Bibliotecario;

public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {

    @Query(value = "SELECT * FROM bibliotecario b WHERE b.bi_senha=:senha and b.bi_login=:login", nativeQuery = true)
    public List<Bibliotecario> findFilterWith(@Param("senha") String senha, @Param("login") String login);

    @Query(value = "SELECT * FROM bibliotecario WHERE bi_status = 0 ORDER BY bi_id ASC", nativeQuery = true)
    public List<Bibliotecario> findAll();

    @Query(value = "SELECT * FROM bibliotecario WHERE bi_nivel = 1 and bi_status=1 ORDER BY bi_id ASC", nativeQuery = true)
    public List<Bibliotecario> findAllAdm();

    @Query(value = "SELECT * FROM bibliotecario WHERE bi_id = :id", nativeQuery = true)
    public List<Bibliotecario> findById(@Param("id") int id);

    @Query(value = "SELECT *FROM bibliotecario where bi_cpf = :cpf", nativeQuery = true)
    public List<Bibliotecario> findByCPF(@Param("cpf") String cpf);

    @Query(value = "SELECT *FROM bibliotecario where bi_login = :login", nativeQuery = true)
    public List<Bibliotecario> findByLogin(@Param("login") String login);

}
