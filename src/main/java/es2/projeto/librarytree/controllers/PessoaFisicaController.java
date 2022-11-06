package es2.projeto.librarytree.controllers;


import es2.projeto.librarytree.models.PessoaFisica;
import es2.projeto.librarytree.services.PessoaFisicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apis")
@RequiredArgsConstructor
public class PessoaFisicaController {
    private PessoaFisicaService pessoaFisicaService;

    @GetMapping("/listaPessoas")
    public ResponseEntity<List<PessoaFisica>> list() {
        return new ResponseEntity<>(this.pessoaFisicaService.getAll(), HttpStatus.OK);
    }

}
