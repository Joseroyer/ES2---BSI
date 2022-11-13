package es2.projeto.librarytree.control;


import es2.projeto.librarytree.Singleton;
import es2.projeto.librarytree.models.Parametrizacao;
import es2.projeto.librarytree.repositories.ParametrizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/apis")
public class ParametrizacaoControl {


    //private static String caminhoImagens="C:/Users/lucas/Documents/imagens/";
    @Autowired
    ParametrizacaoRepository parametrizacaoRepository;

    @Autowired
    Singleton singleton;
  
    // @GetMapping("/testar-param")
    // public ResponseEntity <Object> buscarTodos()
    // {
    //    List <Parametrizacao> params = parametrizacaoRepository.findAll();
    //    if(params.isEmpty())
    //     return new ResponseEntity<>("Não", HttpStatus.OK);
    //    else 
    //     return new ResponseEntity<>("Sim", HttpStatus.OK);
    // }

    @GetMapping("/testar-param")
    public ResponseEntity <Object> buscarTodos()
    {
       
       List <Parametrizacao> parameters = singleton.buscaParametros();
       if(parameters.isEmpty())
        return new ResponseEntity<>("Não", HttpStatus.OK);
       else 
        return new ResponseEntity<>("Sim", HttpStatus.OK);
    }

    // @GetMapping("/estilo")
    // public ResponseEntity <Object> buscarestilo()
    // {
    //    List <Parametrizacao> params = parametrizacaoRepository.findAll();
    //    return new ResponseEntity<>(params,HttpStatus.CREATED);
        
    // }

    @GetMapping("/estilo")
    public ResponseEntity <Object> buscarestilo()
    {
       List <Parametrizacao> parameters = singleton.buscarEstilo();
       return new ResponseEntity<>(parameters,HttpStatus.CREATED);
        
    }

    
    
    @PostMapping("/salvar")
    public void Salvar(@RequestBody Parametrizacao parametrizacao) {
        singleton.SalvarParam(parametrizacao);
    }

    // @PostMapping("/params")
    // public Parametrizacao cadParams(@RequestBody Parametrizacao parametrizacao)
    // {
        
    //     List <Parametrizacao> params = parametrizacaoRepository.findAll();
    //     if(params.isEmpty())
    //        this.parametrizacaoRepository.save(parametrizacao);
    //     else
    //     {
    //         Parametrizacao p = new Parametrizacao();
    //         p.setNome_empresa(parametrizacao.getNome_empresa());
    //         p.setImagem(parametrizacao.getImagem());
    //         p.setId(params.get(0).getId());
    //         this.parametrizacaoRepository.save(p);
    //     }
    //     return parametrizacao;
    // }

}
