package es2.projeto.librarytree.control;
import es2.projeto.librarytree.Singleton;
import es2.projeto.librarytree.models.Bibliotecario;
import es2.projeto.librarytree.repositories.BibliotecarioRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    Singleton singleton;
    
    @PostMapping("/saveBi")
    public Bibliotecario save(@RequestBody Bibliotecario bi) {
        return bibliotecarioRepository.save(bi);
    }

    @RequestMapping("/listarusers")
    public ResponseEntity <Object> buscarTodas()
    {   
        List<Bibliotecario> bibli = singleton.buscarTodosUsers();
        
        return new ResponseEntity<>(bibli,HttpStatus.OK);

    }

    @RequestMapping("/aprovarBibli")
    public Bibliotecario aprovar(Bibliotecario id)
    {   
        Bibliotecario bibli = new Bibliotecario();
        bibli = singleton.aprovar(id);
        return bibli;

    }
}
