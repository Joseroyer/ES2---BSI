package es2.projeto.librarytree.repositories;

import es2.projeto.librarytree.models.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, String> {
}
