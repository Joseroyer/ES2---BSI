package es2.projeto.librarytree.control;

import es2.projeto.librarytree.models.Cliente;
import es2.projeto.librarytree.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apis")
public class ClienteControl {
    private final ClienteRepository clienteRepository;

    @PostMapping("/saveCliente")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cli) {

        return new ResponseEntity<>(clienteRepository.save(cli), HttpStatus.OK);
    }

    @GetMapping("/listClientes")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(clienteRepository.findAll(), HttpStatus.OK);
    }
}
