package es2.projeto.librarytree.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "bibliotecario")
public class Bibliotecario {

    @Id
    @Column(name = "bi_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bi_dta_admissao")
    private Date data_admissao;

    @Column(name = "bi_dta_demissao")
    private Date data_demissao;

    @Column(name = "bi_login")
    private String login;

    @Column(name = "bi_senha")
    private String senha;

    @Column(name = "bi_status")
    private int status;

    @Column(name = "bi_nivel")
    private int nivel;

    @Column(name = "bi_nome")
    private String nome;

    @Column(name = "bi_cpf")
    private String CPF;

    @Column(name = "bi_telefone")
    private String telefone;

    @Column(name = "bi_email")
    private String email;

    public Bibliotecario() {

    }


    public Bibliotecario(Date data_admissao, Date data_demissao, String login, String senha, int status, int nivel,
                         String nome, String cPF, String telefone, String email) {
        this.data_admissao = data_admissao;
        this.data_demissao = data_demissao;
        this.login = login;
        this.senha = senha;
        this.status = status;
        this.nivel = nivel;
        this.nome = nome;
        CPF = cPF;
        this.telefone = telefone;
        this.email = email;
    }


    public Bibliotecario(Long id, Date data_admissao, Date data_demissao, String login, String senha, int status,
                         int nivel, String nome, String cPF, String telefone, String email) {
        this.id = id;
        this.data_admissao = data_admissao;
        this.data_demissao = null;
        this.login = login;
        this.senha = senha;
        this.status = status;
        this.nivel = nivel;
        this.nome = nome;
        CPF = cPF;
        this.telefone = telefone;
        this.email = email;
    }

    public Bibliotecario(Date data_admissao, String login, String senha, int status, int nivel, String nome, String CPF, String telefone, String email) {
        this.data_admissao = data_admissao;
        this.login = login;
        this.senha = senha;
        this.status = status;
        this.nivel = nivel;
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.email = email;
    }
    //    private  static  BibliotecarioRepository bibliotecarioRepository;
//
//    public Bibliotecario save(Bibliotecario bibliotecario){
//        return bibliotecarioRepository.save(bibliotecario);
//    }
//
//    public List <Bibliotecario> findFilterWith(String senha,String login){
//        return bibliotecarioRepository.findFilterWith(senha, login);
//    }

}
