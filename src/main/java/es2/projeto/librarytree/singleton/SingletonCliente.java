package es2.projeto.librarytree.singleton;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import es2.projeto.librarytree.models.Cliente;
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
    
    public List<Cliente> listClientecpf(String filtro) {
        return clienteRepository.findCliente(filtro);
    }

    public Cliente saveCliente(Cliente cli) {
        return clienteRepository.save(cli);
    }

    
    public List<Cliente> listSituacao(String filtro) {
        return clienteRepository.find(filtro);
    }
    
}
