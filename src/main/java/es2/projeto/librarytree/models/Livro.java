package es2.projeto.librarytree.models;


import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Entity
@Table(name = "livro")
public class Livro {
    @Id
    @Column(name = "id_livro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_livro;

    @Column(name = "titulo_livro")
    private String titulo_livro;

    @Column(name = "quantidade")
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "generos_id_genero")
    private Genero generos_id_genero;

    @Column(name = "autor_livro")
    private String autor_livro;

    public Long getId_livro() {
        return id_livro;
    }

    public void setId_livro(Long id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo_livro() {
        return titulo_livro;
    }

    public void setTitulo_livro(String titulo_livro) {
        this.titulo_livro = titulo_livro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Genero getGenero_fk() {
        return generos_id_genero;
    }

    public void setGenero_fk(Genero generos_id_genero) {
        this.generos_id_genero = generos_id_genero;
    }

    public String getAutor_livro() {
        return autor_livro;
    }

    public void setAutor_livro(String autor_livro) {
        this.autor_livro = autor_livro;
    }

    
}
