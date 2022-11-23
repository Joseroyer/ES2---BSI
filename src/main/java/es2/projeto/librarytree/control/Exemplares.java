package es2.projeto.librarytree.control;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es2.projeto.librarytree.models.Livro;
import es2.projeto.librarytree.singleton.SingletonExemplares;
import es2.projeto.librarytree.singleton.SingletonLivro;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("apis")
@RequiredArgsConstructor
public class Exemplares {
    private final SingletonExemplares singletonExemplares;
    private final SingletonLivro singletonLivro;

    @RequestMapping("/listar_exemplares")
    public ResponseEntity<Object> listarExemplar() {
        return new ResponseEntity<>(singletonExemplares.findAllExemplar(), HttpStatus.OK);
    }

    @PostMapping("/saveExemplar")
    public ResponseEntity<Object> save(@RequestBody es2.projeto.librarytree.models.Exemplares ex) {
        return new ResponseEntity<>(singletonExemplares.saveExemplar(ex), HttpStatus.OK);
    }

    @RequestMapping("/excluirExemplar")
    public es2.projeto.librarytree.models.Exemplares excluir(es2.projeto.librarytree.models.Exemplares id) {
        return this.singletonExemplares.excluirExemplares(id);
    }

    @GetMapping("/listar_livros")
    public ResponseEntity<Object> listarLivro() {
        return new ResponseEntity<>(singletonLivro.findAllLivro(), HttpStatus.OK);
    }

    @PostMapping("/saveLivros")
    public ResponseEntity<Object> salvarLivro(@RequestBody Livro livro) {
        Livro livros = new Livro();
        livros = singletonLivro.saveLivro(livro);
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @RequestMapping("/editarExemplar")
    public ResponseEntity<Object> editar(
            @RequestParam(value = "Identificador") es2.projeto.librarytree.models.Exemplares Identificador,
            @RequestParam(value = "Quantidade") int Quantidade,
            @RequestParam(value = "Data") Date data) {
        return new ResponseEntity<>(singletonExemplares.editarExemplares(Identificador, Quantidade, data),
                HttpStatus.OK);
    }
}
