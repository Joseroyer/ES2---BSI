package es2.projeto.librarytree.singleton;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import es2.projeto.librarytree.models.Exemplares;
import es2.projeto.librarytree.repositories.ExemplaresRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Scope("singleton")
public class SingletonExemplares {
    private final ExemplaresRepository exemplaresRepository;

    public List<Exemplares> findAllExemplar() {
        return exemplaresRepository.findAllExemplar();
    }

    public Exemplares saveExemplar(Exemplares exemplares) {
        return exemplaresRepository.save(exemplares);
    }

}
