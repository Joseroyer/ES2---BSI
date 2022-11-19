package es2.projeto.librarytree.singleton;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import es2.projeto.librarytree.models.Cliente;
import es2.projeto.librarytree.models.Editora;
import es2.projeto.librarytree.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Scope("singleton")
public class SingletonCliente {

    private final ClienteRepository clienteRepository;

    public List<Cliente> listCliente() {
        return clienteRepository.findAll();
    }

    public Cliente saveCliente(Cliente cli) {
        return clienteRepository.save(cli);
    }

}
