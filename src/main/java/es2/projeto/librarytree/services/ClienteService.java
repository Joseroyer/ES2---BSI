package es2.projeto.librarytree.services;

import es2.projeto.librarytree.models.Cliente;
import es2.projeto.librarytree.models.PessoaFisica;
import es2.projeto.librarytree.repositories.ClienteRepository;
import es2.projeto.librarytree.repositories.PessoaFisicaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final PessoaFisicaRepository pessoaFisicaRepository;
    private final PessoaFisicaService pessoaService;


    public List <Cliente> getAll(){
        return clienteRepository.findAll();
    }

    public Cliente salvar(Cliente user) {
        return clienteRepository.save(user);
    }

    public Cliente registrar(Cliente user) {
        return this.clienteRepository.save(user);
    }
}
