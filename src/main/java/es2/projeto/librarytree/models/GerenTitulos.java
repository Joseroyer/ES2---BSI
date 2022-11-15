package es2.projeto.librarytree.models;
import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="livro")
public class GerenTitulos {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_livro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_livro;

    @Column(name = "titulo_livro")
    private String titulo_livro;

    @Column(name="quantidade")
    private int quantidade;

    @OneToOne
    @JoinColumn(name = "generos_id_genero", nullable = false)
    private GeneroLivro generos_id_genero_fk;

    @OneToMany
    @JoinColumn(name="autor_id_autor", nullable = false)
    private AutorLivro autor_id_autor_fk;

    @Column(name="livro_stt")
    private int livrostt;

    public GerenTitulos() {
    }

    public GerenTitulos(String titulo_livro, int quantidade, GeneroLivro generos_id_genero_fk,
            AutorLivro autor_id_autor_fk, int livrostt) {
        this.titulo_livro = titulo_livro;
        this.quantidade = quantidade;
        this.generos_id_genero_fk = generos_id_genero_fk;
        this.autor_id_autor_fk = autor_id_autor_fk;
        this.livrostt = livrostt;
    }

    public GerenTitulos(long id_livro, String titulo_livro, int quantidade, GeneroLivro generos_id_genero_fk,
            AutorLivro autor_id_autor_fk, int livrostt) {
        this.id_livro = id_livro;
        this.titulo_livro = titulo_livro;
        this.quantidade = quantidade;
        this.generos_id_genero_fk = generos_id_genero_fk;
        this.autor_id_autor_fk = autor_id_autor_fk;
        this.livrostt = livrostt;
    }

    public long getId_livro() {
        return id_livro;
    }

    public void setId_livro(long id_livro) {
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

    public GeneroLivro getGeneros_id_genero_fk() {
        return generos_id_genero_fk;
    }

    public void setGeneros_id_genero_fk(GeneroLivro generos_id_genero_fk) {
        this.generos_id_genero_fk = generos_id_genero_fk;
    }

    public AutorLivro getAutor_id_autor_fk() {
        return autor_id_autor_fk;
    }

    public void setAutor_id_autor_fk(AutorLivro autor_id_autor_fk) {
        this.autor_id_autor_fk = autor_id_autor_fk;
    }

    public int getLivrostt() {
        return livrostt;
    }

    public void setLivrostt(int livrostt) {
        this.livrostt = livrostt;
    }

    

    
    


}
