package es2.projeto.librarytree.controllers;


import es2.projeto.librarytree.models.Usuario;
import es2.projeto.librarytree.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis")
@RequiredArgsConstructor //só cria construtor se tiver o final
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/registrar")
    public Usuario createUsuario(@RequestBody Usuario user){
        return this.usuarioService.save(user);
    }
}
