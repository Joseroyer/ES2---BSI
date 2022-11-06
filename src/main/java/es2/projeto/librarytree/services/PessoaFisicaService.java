package es2.projeto.librarytree.services;

import es2.projeto.librarytree.models.PessoaFisica;
import es2.projeto.librarytree.repositories.PessoaFisicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaFisicaService {
    private final PessoaFisicaRepository pessoaFisicaRepository;

    public List<PessoaFisica> getAll() {
        return pessoaFisicaRepository.findAll();
    }
}
