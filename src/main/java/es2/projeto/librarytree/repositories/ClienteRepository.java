package es2.projeto.librarytree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es2.projeto.librarytree.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
