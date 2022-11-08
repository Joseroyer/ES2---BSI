package es2.projeto.librarytree.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bibliotecario")
public class Bibliotecario {
    @Id
    @Column(name = "bi_id_b")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pessoafisica_cpf", nullable = false)
    private PessoaFisica pessoafisica_fk;

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

    public Bibliotecario() {
    }

    public Bibliotecario(PessoaFisica pessoafisica_fk, Date data_admissao, Date data_demissao, String login,
            String senha, int status) {
        this.pessoafisica_fk = pessoafisica_fk;
        this.data_admissao = data_admissao;
        this.data_demissao = data_demissao;
        this.login = login;
        this.senha = senha;
        this.status = status;
    }

    public Bibliotecario(Long id, PessoaFisica pessoafisica_fk, Date data_admissao, Date data_demissao, String login,
            String senha, int status) {
        this.id = id;
        this.pessoafisica_fk = pessoafisica_fk;
        this.data_admissao = data_admissao;
        this.data_demissao = data_demissao;
        this.login = login;
        this.senha = senha;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PessoaFisica getPessoafisica_fk() {
        return pessoafisica_fk;
    }

    public void setPessoafisica_fk(PessoaFisica pessoafisica_fk) {
        this.pessoafisica_fk = pessoafisica_fk;
    }

    public Date getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(Date data_admissao) {
        this.data_admissao = data_admissao;
    }

    public Date getData_demissao() {
        return data_demissao;
    }

    public void setData_demissao(Date data_demissao) {
        this.data_demissao = data_demissao;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
