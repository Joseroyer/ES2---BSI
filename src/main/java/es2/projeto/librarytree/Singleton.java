package es2.projeto.librarytree;

import es2.projeto.librarytree.models.Parametrizacao;
import es2.projeto.librarytree.repositories.ParametrizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("singleton")
public class Singleton {


    @Autowired
    ParametrizacaoRepository parametrizacaoRepository;

    public Parametrizacao SalvarParam(Parametrizacao parametrizacao) {
        List<Parametrizacao> params = parametrizacaoRepository.findAll();
        if (params.isEmpty())
            this.parametrizacaoRepository.save(parametrizacao);
        else {
            Parametrizacao p = new Parametrizacao();
            p.setNome_empresa(parametrizacao.getNome_empresa());
            p.setImagem(parametrizacao.getImagem());
            p.setId(params.get(0).getId());
            this.parametrizacaoRepository.save(p);
        }
        return parametrizacao;
    }

    public List<Parametrizacao> buscaParametros()
    {
        List <Parametrizacao> params = parametrizacaoRepository.findAll();
        return params;
    }

    public List<Parametrizacao> buscarEstilo()
    {
        List <Parametrizacao> params = parametrizacaoRepository.findAll();
        return params;
    }
    
}
