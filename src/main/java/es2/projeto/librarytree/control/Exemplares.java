package es2.projeto.librarytree.control;

import es2.projeto.librarytree.singleton.SingletonExemplares;
import es2.projeto.librarytree.singleton.SingletonLivro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("apis")
public class Exemplares {
    private final SingletonExemplares singletonExemplares;
    private final SingletonLivro singletonLivro;
    @GetMapping("listar_exemplares")
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
}
