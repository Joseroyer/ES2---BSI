package es2.projeto.librarytree.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es2.projeto.librarytree.models.Cliente;
import es2.projeto.librarytree.models.Emprestimo;
import es2.projeto.librarytree.singleton.SingletonCliente;
import es2.projeto.librarytree.singleton.SingletonEmprestimo;

@RestController
@RequestMapping("/apis")
public class EmprestimoControl {
    @Autowired
    SingletonCliente singleton;

    @RequestMapping("/existe-cliente")
    public ResponseEntity<Object> buscarFiltro(@RequestParam(value = "filtro") String filtro) {
        List<Cliente> emp = singleton.listClientecpf(filtro);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @RequestMapping("/qual-situacao")
    public ResponseEntity<Object> buscaSituacao(@RequestParam(value = "filtro") String filtro) {
        List<Cliente> emp = singleton.listSituacao(filtro);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }


}
