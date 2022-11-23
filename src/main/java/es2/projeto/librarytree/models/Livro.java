package es2.projeto.librarytree.models;

import javax.persistence.*;


// @NoArgsConstructor
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

    @Column(name="status")
    private int status;

    public Livro()
    {

    }

    public Livro(Long id_livro, String titulo_livro, int quantidade, Genero generos_id_genero, int status) {
        this.id_livro = id_livro;
        this.titulo_livro = titulo_livro;
        this.quantidade = quantidade;
        this.generos_id_genero = generos_id_genero;
        this.status = status;
    }

    public Genero getGeneros_id_genero() {
        return generos_id_genero;
    }

    public void setGeneros_id_genero(Genero generos_id_genero) {
        this.generos_id_genero = generos_id_genero;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

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

    
}
