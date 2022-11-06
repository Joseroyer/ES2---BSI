package es2.projeto.librarytree.models;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ra")
    private Long ra;
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;
    @OneToOne
    @JoinColumn(name = "pessoafisica_cpf")
    private PessoaFisica pessoafisica_fk;


    public Cliente() {

    }

    public Cliente(Long ra, String login, String senha, PessoaFisica pessoafisica_fk) {
        this.ra = ra;
        this.login = login;
        this.senha = senha;
        this.pessoafisica_fk = pessoafisica_fk;
    }

    public Long getRa() {
        return ra;
    }

    public void setRa(Long ra) {
        this.ra = ra;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PessoaFisica getPessoafisica_fk() {
        return pessoafisica_fk;
    }

    public void setPessoafisica_fk(PessoaFisica pessoafisica_fk) {
        this.pessoafisica_fk = pessoafisica_fk;
    }
}
