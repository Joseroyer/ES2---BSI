package es2.projeto.librarytree.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "parametrizacao")
public class Parametrizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    @Column(name = "nome_empresa")
    private String nome_empresa;

    @Column(name = "imagem")
    private String imagem;
    
    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cnpj")
    private String cnpj;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    


    public Parametrizacao(long id, String nome_empresa, String imagem, String cidade, String estado, String cnpj) {
        this.id = id;
        this.nome_empresa = nome_empresa;
        this.imagem = imagem;
        this.cidade = cidade;
        this.estado = estado;
        this.cnpj = cnpj;
    }

    public Parametrizacao() {
    }

    // public int getLogotipo() {
    //     return logotipo;
    // }

    // public void setLogotipo(int logotipo) {
    //     this.logotipo = logotipo;
    // }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

  

    // public String getLogotipo() {
    //     return logotipo;
    // }

    // public void setLogotipo(String logotipo) {
    //     this.logotipo = logotipo;
    // }

    // public byte[] getLogotipo() {
    //     return logotipo;
    // }

    // public void setLogotipo(byte[] logotipo) {
    //     this.logotipo = logotipo;
    // }
    
}



