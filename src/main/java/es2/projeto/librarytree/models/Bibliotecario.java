package es2.projeto.librarytree.models;

import javax.persistence.*;


@Entity
@Table(name = "bibliotecario")
public class Bibliotecario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bi_id_b")
    private long id;
    @OneToOne
    @JoinColumn(name = "pessoafisica_cpf")
    private PessoaFisica pessoafisica_fk;
    @Column(name = "bi_dta_admissao")
    private String data_admissao;
    @Column(name = "bi_dta_demissao")
    private String data_demissao;
    @Column(name = "bi_login")
    private String login;
    @Column(name = "bi_senha")
    private String senha;
    @Column(name = "bi_status")
    private int status;

    public Bibliotecario() {
    }

    public Bibliotecario(long id, PessoaFisica pessoafisica_fk, String data_admissao, String data_demissao, String senha, String login, int status) {
        this.id = id;
        this.pessoafisica_fk = pessoafisica_fk;
        this.data_admissao = data_admissao;
        this.data_demissao = data_demissao;
        this.senha = senha;
        this.login = login;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PessoaFisica getPessoafisica_fk() {
        return pessoafisica_fk;
    }

    public void setPessoafisica_fk(PessoaFisica pessoafisica_fk) {
        this.pessoafisica_fk = pessoafisica_fk;
    }

    public String getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(String data_admissao) {
        this.data_admissao = data_admissao;
    }

    public String getData_demissao() {
        return data_demissao;
    }

    public void setData_demissao(String data_demissao) {
        this.data_demissao = data_demissao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
