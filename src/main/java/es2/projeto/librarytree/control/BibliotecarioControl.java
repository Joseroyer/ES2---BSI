package es2.projeto.librarytree.control;
import es2.projeto.librarytree.models.Bibliotecario;
import es2.projeto.librarytree.repositories.BibliotecarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apis")
public class BibliotecarioControl {
    private final BibliotecarioRepository bibliotecarioRepository;

    @PostMapping("/saveBi")
    public Bibliotecario save(@RequestBody Bibliotecario bi) {
        return bibliotecarioRepository.save(bi);
    }
}
