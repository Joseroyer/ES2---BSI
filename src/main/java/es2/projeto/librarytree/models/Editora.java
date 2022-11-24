package es2.projeto.librarytree.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "editora")
public class Editora implements Serializable
{
    
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_editora")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_editora;

    @Column(name = "nome_editora")
    private String nome_editora;

    @Column(name = "cidade_editora")
    private String cidade_editora;

    @Column(name = "estado_editora")
    private String estado_editora;

    @Column(name = "status")
    private int status;
    

    public String getCidade_editora() {
        return cidade_editora;
    }


    public void setCidade_editora(String cidade_editora) {
        this.cidade_editora = cidade_editora;
    }


    public String getEstado_editora() {
        return estado_editora;
    }


    public void setEstado_editora(String estado_editora) {
        this.estado_editora = estado_editora;
    }


    public Editora() {
    }
    

  
    public Editora(Long id_editora) {
        this.id_editora = id_editora;
    }


    public Editora(Long id_editora, String nome_editora, String cidade_editora, String estado_editora, int status) {
        this.id_editora = id_editora;
        this.nome_editora = nome_editora;
        this.cidade_editora = cidade_editora;
        this.estado_editora = estado_editora;
        this.status = status;
    }


    public Long getId_editora() {
        return id_editora;
    }

    public void setId_editora(Long id_editora) {
        this.id_editora = id_editora;
    }

    public String getNome_editora() {
        return nome_editora;
    }

    public void setNome_editora(String nome_editora) {
        this.nome_editora = nome_editora;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
