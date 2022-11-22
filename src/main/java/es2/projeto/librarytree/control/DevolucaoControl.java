package es2.projeto.librarytree.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es2.projeto.librarytree.models.Emprestimo;
import es2.projeto.librarytree.singleton.SingletonDevolucao;

@RestController
@RequestMapping("/apis")
public class DevolucaoControl {

    @Autowired
    SingletonDevolucao singletonDevolucao;
    
    @RequestMapping("/listar-emprestimos")
    public ResponseEntity<Object> buscarTodos() {
        List<Emprestimo> ee = singletonDevolucao.buscarTodas();
        return new ResponseEntity<>(ee, HttpStatus.OK);

    }

    @RequestMapping("/pagar")
    public Emprestimo pagar(@RequestParam(value = "identificador") Emprestimo identificador,@RequestParam(value = "num") String num, @RequestParam(value = "qtd") String qtd)
    {
        Emprestimo e = new Emprestimo();
        e = singletonDevolucao.pagar(identificador,num, qtd);
        return e;
    }

    @RequestMapping("/listar-emprestimos-filtro")
    public ResponseEntity<Object> buscarFiltro(@RequestParam(value = "filtro")String filtro) {
        List<Emprestimo> ee = singletonDevolucao.buscarfiltro(filtro);
        System.out.println(filtro);
        return new ResponseEntity<>(ee, HttpStatus.OK);

    }

    @RequestMapping("/devolver")
    public Emprestimo devolver(@RequestParam(value="id")Emprestimo id) 
    {
        Emprestimo ee = new Emprestimo();
        ee = singletonDevolucao.devolverExemplar(id);
        return ee;

    }
    
}
