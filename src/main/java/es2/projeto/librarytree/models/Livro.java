package es2.projeto.librarytree.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "livro")
public class Livro {
    @Id
    @Column(name = "id_livro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo_livro")
    private String titulo;
    @Column(name = "quantidade")
    private int quantidade;
    @ManyToOne
    @JoinColumn(name = "generos_id_genero")
    private Genero genero_fk;

    public Livro() {
    }

    
    // @JsonCreator
    // public Livro(@JsonProperty("id") Long id, @JsonProperty("titulo") String
    // titulo,
    // @JsonProperty("quantidade") int quantidade, @JsonProperty("genero_fk") Genero
    // genero_fk) {
    // this.id = id;
    // this.titulo = titulo;
    // this.quantidade = quantidade;
    // this.genero_fk = genero_fk;
    // }

    public Livro(Long id, String titulo, int quantidade, Genero genero_fk) {
        this.id = id;
        this.titulo = titulo;
        this.quantidade = quantidade;
        this.genero_fk = genero_fk;
    }


    public Livro(String titulo, int quantidade, Genero genero_fk) {
        this.titulo = titulo;
        this.quantidade = quantidade;
        this.genero_fk = genero_fk;
    }

}
