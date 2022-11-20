package es2.projeto.librarytree.singleton;

import es2.projeto.librarytree.models.Livro;
import es2.projeto.librarytree.repositories.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Scope("singleton")
public class SingletonLivro {

    private final LivroRepository livroRepository;
    public List<Livro> findAllLivro(){
        return  livroRepository.findAll();
    }
}
