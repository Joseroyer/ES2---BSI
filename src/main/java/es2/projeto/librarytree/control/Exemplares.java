package es2.projeto.librarytree.control;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es2.projeto.librarytree.singleton.SingletonExemplares;
import es2.projeto.librarytree.singleton.SingletonLivro;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("apis")
public class Exemplares {
    private final SingletonExemplares singletonExemplares;
    private final SingletonLivro singletonLivro;

    @RequestMapping("listar_exemplares")
    public ResponseEntity<Object> listarExemplar() {
        return new ResponseEntity<>(singletonExemplares.findAllExemplar(), HttpStatus.OK);
    }

    @GetMapping("listar_livros")
    public ResponseEntity<Object> listarLivro() {
        return new ResponseEntity<>(singletonLivro.findAllLivro(), HttpStatus.OK);
    }

    @PostMapping("save/Exemplar")
    public ResponseEntity<Object> save(@RequestBody es2.projeto.librarytree.models.Exemplares ex) {
        return new ResponseEntity<>(singletonExemplares.saveExemplar(ex), HttpStatus.OK);
    }

    @RequestMapping("/excluirExemplar")
    public es2.projeto.librarytree.models.Exemplares excluir(es2.projeto.librarytree.models.Exemplares id) {
        return this.singletonExemplares.excluirExemplares(id);
    }
}
