package es2.projeto.librarytree.services;

import es2.projeto.librarytree.repositories.PessoaFisicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoaFisicaService {
    private final PessoaFisicaRepository pessoaFisicaRepository;
}
