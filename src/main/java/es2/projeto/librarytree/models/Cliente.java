package es2.projeto.librarytree.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private Long id;

    @Column(name = "cli_nome")
    private String nome;

    @Column(name = "cli_telefone")
    private String telefone;

    @Column(name = "cli_email")
    private String email;

    @Column(name = "cli_cpf")
    private String CPF;

    @Column(name = "cli_login")
    private String login;

    @Column(name = "cli_senha")
    private String senha;


    public Cliente() {
        this(0L,"","","","","","");
    }

    public Cliente(Long id, String nome, String telefone, String email, String CPF, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.CPF = CPF;
        this.login = login;
        this.senha = senha;
    }

    public Cliente(String nome, String telefone, String email, String CPF, String login, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.CPF = CPF;
        this.login = login;
        this.senha = senha;
    }
    //Metodos
//    private  static ClienteRepository clienteRepository;
//
//    public List <Cliente> findAllWithFilter(String senha, String login){
//        return clienteRepository.findAllWithFilter(senha, login);
//    }
//
//    public Cliente save(Cliente cliente) {
//        return clienteRepository.save(cliente);
//    }
}
