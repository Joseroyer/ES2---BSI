package es2.projeto.librarytree.controllers;


import es2.projeto.librarytree.models.PessoaFisica;
import es2.projeto.librarytree.services.PessoaFisicaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis")
@Log4j2
@RequiredArgsConstructor
public class PessoaFisicaController {
    private final PessoaFisicaService pessoaFisicaService;

    @PostMapping("/save")
    public ResponseEntity<PessoaFisica> save(@RequestBody PessoaFisica pessoaFisica) {
        return new ResponseEntity<>(pessoaFisicaService.save(pessoaFisica), HttpStatus.CREATED);
    }

    @GetMapping("/listaPessoa")
    public ResponseEntity<Object> listar() {
        return new ResponseEntity<>(pessoaFisicaService.getAll(), HttpStatus.OK);
    }


}
