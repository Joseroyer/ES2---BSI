package es2.projeto.librarytree.services;

import es2.projeto.librarytree.models.Cliente;
import es2.projeto.librarytree.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

//    public Cliente salvar(Cliente user){
//        return clienteRepository.save(user);
//    }
}
