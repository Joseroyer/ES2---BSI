package es2.projeto.librarytree.control;


import es2.projeto.librarytree.singleton.SingletonExemplares;
import es2.projeto.librarytree.singleton.SingletonLivro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("apis")
public class Exemplares {
    private final SingletonExemplares singleton;
    private final SingletonLivro singletonLivro;

    @GetMapping("listar-exemplares")
    public ResponseEntity<Object> listarExemplar(){
        return new ResponseEntity<>(singleton.findAllExemplar(), HttpStatus.OK);
    }

    @GetMapping("listar-livros")
    public ResponseEntity<Object> listarLivro(){
        return new ResponseEntity<>(singletonLivro.findAllLivro(), HttpStatus.OK);
    }
}
