package es2.projeto.librarytree.singleton;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import es2.projeto.librarytree.repositories.ParametrizacaoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Scope("singleton")
public class SingletonParametrizacao {

    private final ParametrizacaoRepository parametrizacaoRepository;

}
