package es2.projeto.librarytree.singleton;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import es2.projeto.librarytree.models.Bibliotecario;
import es2.projeto.librarytree.repositories.BibliotecarioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Scope("singleton")
public class SingletonBibliotecario {

    private final BibliotecarioRepository bibliotecarioRepository;

    public List<Bibliotecario> findByCPF(String cpf) {
        return bibliotecarioRepository.findByCPF(cpf);
    }

    public List<Bibliotecario> findByLogin(String login) {
        return bibliotecarioRepository.findByLogin(login);
    }

    public Bibliotecario saveBibliotecario(Bibliotecario bi) {
        return bibliotecarioRepository.save(bi);
    }

    public List<Bibliotecario> buscarTodosUsers() {
        List<Bibliotecario> bibli = bibliotecarioRepository.findAll();
        return bibli;
    }

    public Bibliotecario edBibliotecario(Bibliotecario Identificador, String Nome, String telefone, String email) {
        Bibliotecario editor = new Bibliotecario();
        Optional<Bibliotecario> bli = bibliotecarioRepository.findById(Identificador.getId());
        Identificador.setId(bli.get().getId());
        Identificador.setNome(Nome);
        Identificador.setTelefone(telefone);
        Identificador.setEmail(email);
        return this.bibliotecarioRepository.save(Identificador);
    }

    public Bibliotecario aprovar(Bibliotecario id) {
        Optional<Bibliotecario> bibli = bibliotecarioRepository.findById(id.getId());
        id.setStatus(1);
        id.setCPF(bibli.get().getCPF());
        id.setData_admissao(bibli.get().getData_admissao());
        id.setData_demissao(bibli.get().getData_demissao());
        id.setEmail(bibli.get().getEmail());
        id.setId(bibli.get().getId());
        id.setLogin(bibli.get().getLogin());
        id.setNivel(bibli.get().getNivel());
        id.setNome(bibli.get().getNome());
        id.setSenha(bibli.get().getSenha());
        id.setTelefone(bibli.get().getTelefone());
        return this.bibliotecarioRepository.save(id);

    }

    public List<Bibliotecario> buscarTodosAdms() {
        List<Bibliotecario> bibli = bibliotecarioRepository.findAllAdm();
        return bibli;
    }

    public Bibliotecario excluir(Bibliotecario id) {
        Optional<Bibliotecario> bibli = bibliotecarioRepository.findById(id.getId());
        id.setStatus(-1);
        id.setCPF(bibli.get().getCPF());
        id.setData_admissao(bibli.get().getData_admissao());
        id.setData_demissao(bibli.get().getData_demissao());
        id.setEmail(bibli.get().getEmail());
        id.setId(bibli.get().getId());
        id.setLogin(bibli.get().getLogin());
        id.setNivel(bibli.get().getNivel());
        id.setNome(bibli.get().getNome());
        id.setSenha(bibli.get().getSenha());
        id.setTelefone(bibli.get().getTelefone());
        return this.bibliotecarioRepository.save(id);
    }

    public Bibliotecario editarBibliotecario(Bibliotecario Identificador, String Nome, String Telefone, String email) {
        Optional<Bibliotecario> bibli = bibliotecarioRepository.findById(Identificador.getId());
        Identificador.setId(bibli.get().getId());
        Identificador.setNome(Nome);
        Identificador.setTelefone(Telefone);
        Identificador.setEmail(email);
        return this.bibliotecarioRepository.save(Identificador);
    }

    public Optional<Bibliotecario> buscarBibliotecario(Long id) {
        Optional<Bibliotecario> bi = bibliotecarioRepository.findById(id);
        return bi;
    }

}
