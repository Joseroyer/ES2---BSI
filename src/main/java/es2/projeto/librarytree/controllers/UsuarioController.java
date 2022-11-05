package es2.projeto.librarytree.controllers;


import es2.projeto.librarytree.models.Usuario;
import es2.projeto.librarytree.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis")
@RequiredArgsConstructor //só cria construtor se tiver o final
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/registrar")
    public Usuario createUsuario(@RequestBody Usuario user) {
        return this.usuarioService.save(user);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> list() {
        return new ResponseEntity<>(this.usuarioService.getAll(),HttpStatus.OK);
    }
}
