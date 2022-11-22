package es2.projeto.librarytree.singleton;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import es2.projeto.librarytree.models.Exemplar;
import es2.projeto.librarytree.repositories.ExemplarRepository;



@Service
@Scope("singleton")
public class SingletonEmprestimo {

    @Autowired
    ExemplarRepository eRepository;

    public List<Exemplar> buscarTodas() {
        List<Exemplar> ee = eRepository.findAll();
        return ee;
    }
}
