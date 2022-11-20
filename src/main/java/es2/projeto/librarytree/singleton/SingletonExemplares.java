package es2.projeto.librarytree.singleton;

import es2.projeto.librarytree.models.Exemplares;
import es2.projeto.librarytree.models.Livro;
import es2.projeto.librarytree.repositories.ExemplaresRepository;
import es2.projeto.librarytree.repositories.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Scope("singleton")
public class SingletonExemplares {
    private  final ExemplaresRepository exemplaresRepository;


    public List<Exemplares> findAllExemplar(){
        return exemplaresRepository.findAll();
    }


}
