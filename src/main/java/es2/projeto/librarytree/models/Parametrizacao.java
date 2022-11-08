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

    

    public Parametrizacao(String nome_empresa, String imagem) {
        this.nome_empresa = nome_empresa;
        this.imagem = imagem;
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
