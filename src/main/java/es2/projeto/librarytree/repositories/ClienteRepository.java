package es2.projeto.librarytree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es2.projeto.librarytree.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value="SELECT * FROM cliente u WHERE u.cli_senha=:senha and u.cli_login=:login",nativeQuery=true)
    public List<Cliente> findAllWithFilter(@Param("senha") String senha, @Param("login") String login);
}
