package es2.projeto.librarytree.control;

import es2.projeto.librarytree.Singleton;
import es2.projeto.librarytree.models.Cliente;
import es2.projeto.librarytree.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apis")
public class ClienteControl {
    // private final ClienteRepository clienteRepository;

    @Autowired
    Singleton singleton;

    @PostMapping("/saveCliente")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cli) {

        return new ResponseEntity<>(singleton.saveCliente(cli), HttpStatus.OK);
    }

    @GetMapping("/listClientes")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(singleton.listCliente(), HttpStatus.OK);
    }


}
