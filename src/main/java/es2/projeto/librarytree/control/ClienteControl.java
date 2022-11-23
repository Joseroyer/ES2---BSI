package es2.projeto.librarytree.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es2.projeto.librarytree.models.Cliente;
import es2.projeto.librarytree.singleton.SingletonCliente;

@RestController
@RequestMapping("/apis")
public class ClienteControl {
    // private final ClienteRepository clienteRepository;

    @Autowired
    SingletonCliente singleton;

    @PostMapping("/saveCliente")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cli) {

        return new ResponseEntity<>(singleton.saveCliente(cli), HttpStatus.OK);
    }

    @GetMapping("/listClientes")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(singleton.listCliente(), HttpStatus.OK);
    }

    @RequestMapping("/qual-situacao")
    public ResponseEntity<Object> buscaSituacao(@RequestParam(value = "filtro") String filtro) {
        List<Cliente> emp = singleton.listSituacao(filtro);
        if(emp.isEmpty())
            return new ResponseEntity<>(emp, HttpStatus.NOT_ACCEPTABLE);
        else
            return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping("/existe-cliente")
    public ResponseEntity<Object> buscarFiltro(@RequestParam(value = "filtro") String filtro) {
        
        List<Cliente> emp = singleton.listClientecpf(filtro);
        if(emp.isEmpty())
            return new ResponseEntity<>(emp, HttpStatus.NOT_ACCEPTABLE);
        else
            return new ResponseEntity<>(emp, HttpStatus.OK);
    }

}
