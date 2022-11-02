package es2.projeto.librarytree.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis")
@RequiredArgsConstructor //só cria construtor se tiver o final
public class usuarioController {

//    private final usuarioRepository usuarioRepository;
    @GetMapping("Ola")
    public String hello(){
        return "Olá, tudo Bem";
    }
}
