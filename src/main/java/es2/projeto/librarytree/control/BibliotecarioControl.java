package es2.projeto.librarytree.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es2.projeto.librarytree.Singleton;
import es2.projeto.librarytree.models.Bibliotecario;
import es2.projeto.librarytree.repositories.BibliotecarioRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apis")
public class BibliotecarioControl {

    @Autowired
    Singleton singleton;

    @Autowired
    BibliotecarioRepository bibliotecarioRepository;

    @PostMapping("/saveBi")
    public ResponseEntity<Object> save(@RequestBody Bibliotecario bi) {
        List<Bibliotecario> bil_cpf = singleton.findByCPF(bi.getCPF());
        List<Bibliotecario> bil_login = singleton.findByLogin(bi.getCPF());

        if (bil_cpf.isEmpty() && bil_login.isEmpty()) {
            bi.setNivel(1);
            return new ResponseEntity<>(singleton.saveBibliotecario(bi), HttpStatus.OK);

        } else
            return new ResponseEntity<>("CPF Existente", HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping("/listarusers")
    public ResponseEntity<Object> buscarTodas() {
        List<Bibliotecario> bibli = singleton.buscarTodosUsers();

        return new ResponseEntity<>(bibli, HttpStatus.OK);

    }

    @RequestMapping("/listaradm")
    public ResponseEntity<Object> buscarAdm() {
        List<Bibliotecario> bibli = singleton.buscarTodosAdms();

        return new ResponseEntity<>(bibli, HttpStatus.OK);

    }

    @RequestMapping("/aprovarBibli")
    public Bibliotecario aprovar(Bibliotecario id) {
        Bibliotecario bibli = new Bibliotecario();
        bibli = singleton.aprovar(id);
        return bibli;

    }

    @RequestMapping("/excluirAdm")
    public Bibliotecario excluir(Bibliotecario id) {
        Bibliotecario bibli = new Bibliotecario();
        bibli = singleton.excluir(id);
        return bibli;

    }

    @RequestMapping("/editarBibliotecario")
    public ResponseEntity<Object> editar(@RequestParam(value = "Identificador") Bibliotecario Identificador,
            @RequestParam(value = "Nome") String Nome,
            @RequestParam(value = "Telefone") String Telefone, @RequestParam(value = "Email") String Email) {
        Bibliotecario bli = new Bibliotecario();
        bli = singleton.edBibliotecario(Identificador, Nome, Telefone, Email);
        return new ResponseEntity<>(bli, HttpStatus.OK);
    }
}
