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

    @Column(name = "logotipo")
    private int logotipo;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    // public byte[] getLogotipo() {
    //     return logotipo;
    // }

    // public void setLogotipo(byte[] logotipo) {
    //     this.logotipo = logotipo;
    // }
    

    public Parametrizacao(String nome_empresa, int logotipo) {
        this.nome_empresa = nome_empresa;
        this.logotipo = logotipo;
    }

    public Parametrizacao() {
    }

    public int getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(int logotipo) {
        this.logotipo = logotipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
}
