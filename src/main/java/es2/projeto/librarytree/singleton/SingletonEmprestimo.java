package es2.projeto.librarytree.singleton;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import es2.projeto.librarytree.models.Cliente;
import es2.projeto.librarytree.repositories.ClienteRepository;


@Service
@Scope("singleton")
public class SingletonEmprestimo {
 
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> buscaFiltro(String filtro) {
        List<Cliente> emp = clienteRepository.findAllWithFilter(filtro);
        return emp;
    }

}
