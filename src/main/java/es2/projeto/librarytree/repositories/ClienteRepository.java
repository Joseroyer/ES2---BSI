package es2.projeto.librarytree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es2.projeto.librarytree.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value="SELECT * FROM cliente u WHERE u.cli_senha=:senha and u.cli_login=:login",nativeQuery=true)
    public List<Cliente> findAllWithFilter(@Param("senha") String senha, @Param("login") String login);

    @Query(value = "SELECT * FROM cliente c WHERE c.cli_cpf = :filtro", nativeQuery = true)
    public List<Cliente> findCliente(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM cliente c WHERE c.cli_cpf = :filtro AND c.situacao = 0", nativeQuery = true)
    public List<Cliente> find(@Param("filtro") String filtro);
}
