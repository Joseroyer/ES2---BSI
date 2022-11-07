package es2.projeto.librarytree.controllers;


import es2.projeto.librarytree.models.PessoaFisica;
import es2.projeto.librarytree.services.PessoaFisicaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis")
@Log4j2
@RequiredArgsConstructor
public class PessoaFisicaController {
    private final PessoaFisicaService pessoaFisicaService;


    @GetMapping("/Ola")
    public String hello() {
        return "Ola, tudo bem";
    }

    @GetMapping("/listaPessoas")
    public ResponseEntity<List<PessoaFisica>> list() {
        return new ResponseEntity<>(pessoaFisicaService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public PessoaFisica save(@RequestBody PessoaFisica pessoaFisica){
        return  pessoaFisicaService.save(pessoaFisica);
    }


}
