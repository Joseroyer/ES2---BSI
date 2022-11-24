package es2.projeto.librarytree.singleton;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import es2.projeto.librarytree.models.Livro;
import es2.projeto.librarytree.repositories.LivroRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Scope("singleton")
public class SingletonLivro {

    private final LivroRepository livroRepository;

    public List<Livro> findAllLivro() {
        return livroRepository.findAll();
    }

    public Livro saveLivro(Livro livro) {
        return livroRepository.save(livro);
    }
}
