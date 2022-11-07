package es2.projeto.librarytree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es2.projeto.librarytree.models.Parametrizacao;
import es2.projeto.librarytree.repositories.ParametrizacaoRepository;

@RestController
@RequestMapping("/apis")
public class ParametrizacaoRestContoller {
    
    @Autowired
    ParametrizacaoRepository parametrizacaoRepository;

    @GetMapping("/testar-param")
    public ResponseEntity <Object> buscarTodos()
    {
       List <Parametrizacao> params = parametrizacaoRepository.findAll();
       if(params.isEmpty())
        return new ResponseEntity<>("Não", HttpStatus.OK);
       else 
        return new ResponseEntity<>("Sim", HttpStatus.OK);
    }

    @GetMapping("/estilo")
    public ResponseEntity <Object> buscarestilo()
    {
       List <Parametrizacao> params = parametrizacaoRepository.findAll();
       return new ResponseEntity<>(params,HttpStatus.CREATED);
        
    }

    @PostMapping("/params")
    public Parametrizacao cadParams(@RequestBody Parametrizacao parametrizacao) {return this.parametrizacaoRepository.save(parametrizacao);}
}

