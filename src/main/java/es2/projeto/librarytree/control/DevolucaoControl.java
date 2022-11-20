package es2.projeto.librarytree.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es2.projeto.librarytree.models.Emprestimo;
import es2.projeto.librarytree.models.EmprestimoExemplar;
import es2.projeto.librarytree.singleton.SingletonDevolucao;

@RestController
@RequestMapping("/apis")
public class DevolucaoControl {

    @Autowired
    SingletonDevolucao singletonDevolucao;
    
    @RequestMapping("/listar-emprestimos")
    public ResponseEntity<Object> buscarTodos() {
        List<EmprestimoExemplar> ee = singletonDevolucao.buscarTodas();
        return new ResponseEntity<>(ee, HttpStatus.OK);

    }
    
}
