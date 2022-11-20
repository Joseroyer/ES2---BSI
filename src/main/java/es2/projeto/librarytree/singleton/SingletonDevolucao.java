package es2.projeto.librarytree.singleton;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import es2.projeto.librarytree.models.Emprestimo;
import es2.projeto.librarytree.models.EmprestimoExemplar;
import es2.projeto.librarytree.repositories.DevolucaoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Scope("singleton")
public class SingletonDevolucao 
{
    
    private final DevolucaoRepository devolucaoRepository;

    public List<EmprestimoExemplar> buscarTodas() {
        List<EmprestimoExemplar> ee = devolucaoRepository.findExemplares();
        return ee;
    }

}
