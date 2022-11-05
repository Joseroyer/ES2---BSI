package es2.projeto.librarytree.controllers;


import es2.projeto.librarytree.models.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis")
@RequiredArgsConstructor //só cria construtor se tiver o final
public class usuarioController {

    private final usuarioService usuarioService;

//    @PostMapping("/registrar")
//    public Usuarioa createUsuario(ResponseBody Usuario usario){
//        return this.usarioService.save(usuario);
//    }
}
