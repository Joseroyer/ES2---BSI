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
@RequestMapping(value="/apis")
public class ParametrizacaoControl {


    @Autowired
    ParametrizacaoRepository parametrizacaoRepository;

    @Autowired
    Singleton singleton;
  

    @RequestMapping(value="/testar-param")
    public ResponseEntity <Object> buscarTodos()
    {
       
       List <Parametrizacao> parameters = singleton.buscaParametros();
       if(parameters.isEmpty())
        return new ResponseEntity<>("Não", HttpStatus.OK);
       else 
        return new ResponseEntity<>("Sim", HttpStatus.OK);
    }

    @RequestMapping(value="/estilo")
    public ResponseEntity <Object> buscarestilo()
    {
       List <Parametrizacao> parameters = singleton.buscarEstilo();
       return new ResponseEntity<>(parameters,HttpStatus.CREATED);
        
    }

    
    
    @PostMapping(value="/salvar")
    public void Salvar(@RequestBody Parametrizacao parametrizacao) {
        singleton.SalvarParam(parametrizacao);
    }

}
