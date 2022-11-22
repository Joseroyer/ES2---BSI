package es2.projeto.librarytree.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es2.projeto.librarytree.models.Exemplar;
import es2.projeto.librarytree.singleton.SingletonEmprestimo;

@RestController
@RequestMapping("/apis")
public class EmprestimoControl {
    @Autowired
    SingletonEmprestimo singletonEmp;

    @RequestMapping("/livros")
    public ResponseEntity<Object> buscarTodos() {
        List<Exemplar> ee = singletonEmp.buscarTodas();
        return new ResponseEntity<>(ee, HttpStatus.OK);

    }

}
