package es2.projeto.librarytree.models;


import javax.persistence.*;


@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Long id;
    @Column(name = "usu_nome")
    private String nome;
    @Column(name = "usu_email")
    private String email;
    @Column(name = "usu_senha")
    private String senha;
    @Column(name = "usu_CPF")
    private String CPF;
    @Column(name = "usu_telefone")
    private String telefone;

    @Column(name = "usu_user")
    private String user;

    public Usuario() {

    }

    public Usuario(String nome, String email, String senha, String CPF, String telefone, String user) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.CPF = CPF;
        this.telefone = telefone;
        this.user = user;
    }

    public Usuario(Long id, String nome, String email, String senha, String CPF, String telefone, String user) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.CPF = CPF;
        this.telefone = telefone;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}

