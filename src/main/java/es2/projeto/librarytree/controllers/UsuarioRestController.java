package es2.projeto.librarytree.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es2.projeto.librarytree.repositories.BibliotecarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es2.projeto.librarytree.models.Bibliotecario;
import es2.projeto.librarytree.models.Cliente;
import es2.projeto.librarytree.models.PessoaFisica;
import es2.projeto.librarytree.repositories.ClienteRepository;
import es2.projeto.librarytree.repositories.PessoaFisicaRepository;
import es2.projeto.librarytree.security.JWTTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/security")
public class UsuarioRestController {

    private final PessoaFisicaRepository pessoaFisicaRepository;
    private final ClienteRepository clienteRepository;
    private final BibliotecarioRepository bibliotecarioRepository;

    private final HttpServletRequest request;

    @PostMapping("/testar-acesso")
    public ResponseEntity<Object> testarAcesso() {
        String token = request.getHeader("Authorization");
        if (JWTTokenProvider.verifyToken(token))
            return new ResponseEntity<>("Logado", HttpStatus.OK);
        else
            return new ResponseEntity<>("Erro", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }

    @PostMapping("/autenticar")
    public ResponseEntity<Object> autenticar1(String login, String senha, boolean adm) {
        int i = 0, pos = 0;
        if (adm == true) {
            List<Bibliotecario> user = bibliotecarioRepository.findFilterWith(senha, login);
            for (i = 0; i < user.size(); i++)
                if (senha.equals(user.get(i).getSenha()) && login.equals(user.get(i).getLogin()))
                    pos = 1;
            String token = "";
            if (pos == 1) {
                token = JWTTokenProvider.getToken(senha, "ADM");
                System.out.println(token);
                return new ResponseEntity<>(token, HttpStatus.OK);
            } else
                return new ResponseEntity<>("ACESSO NAO PERMITIDO", HttpStatus.NOT_ACCEPTABLE);
        } else {
            List<Cliente> user = clienteRepository.findAllWithFilter(senha, login);
            for (i = 0; i < user.size(); i++)
                if (senha.equals(user.get(i).getSenha()) && login.equals(user.get(i).getLogin()))
                    pos = 1;
            String token = "";
            if (pos == 1) {
                token = JWTTokenProvider.getToken(senha, "ADM");
                System.out.println(token);
                return new ResponseEntity<>(token, HttpStatus.OK);
            } else
                return new ResponseEntity<>("ACESSO NAO PERMITIDO", HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @PostMapping("/save")
    public String save(@RequestBody PessoaFisica pessoaFisica){
        pessoaFisicaRepository.save(pessoaFisica);
        Cliente cliente = new Cliente();
        cliente.setPessoafisica_fk(pessoaFisica);
        cliente.setLogin(request.getParameter("login"));
        cliente.setSenha(request.getParameter("senha"));
        clienteRepository.save(cliente);
        return "Salvo";
    }

//    @PostMapping("/save")
//    public ResponseEntity<Object> save(@RequestBody Cliente cliente){
//        this.clienteRepository.save(cliente);
//        return new ResponseEntity<>("salvo",HttpStatus.OK);
//    }
}
