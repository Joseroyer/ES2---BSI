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

    @Column(name = "status")
    private int status;
    

    public Editora() {
    }
    

    public Editora(Long id_editora, String nome_editora, int status) {
        this.id_editora = id_editora;
        this.nome_editora = nome_editora;
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
}
