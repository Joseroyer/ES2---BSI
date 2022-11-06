package es2.projeto.librarytree.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoafisica")
public class PessoaFisica {
    @Id
    @Column(name = "pes_cpf")
    private String cpf;

    @Column(name = "pes_nome")
    private String nome;
    @Column(name = "pes_telefone")
    private String telefone;
    @Column(name = "pes_email")
    private String email;
    @Column(name = "nivel_adm")
    private int nivel_adm;


    public PessoaFisica() {
    }

    public PessoaFisica(String cpf, String nome, String telefone, String email, int nivel_adm) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.nivel_adm = nivel_adm;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNivel_adm() {
        return nivel_adm;
    }

    public void setNivel_adm(int nivel_adm) {
        this.nivel_adm = nivel_adm;
    }
}
