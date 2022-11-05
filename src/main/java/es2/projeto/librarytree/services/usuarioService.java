package es2.projeto.librarytree.services;


import es2.projeto.librarytree.repositories.usuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service //regra,lógica de negocio, classe controler fica bem clean.
@RequiredArgsConstructor

public class usuarioService {
    private final usuarioRepository usuarioRepository;
}
