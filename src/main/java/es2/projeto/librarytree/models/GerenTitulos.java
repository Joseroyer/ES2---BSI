package es2.projeto.librarytree.models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

@Column(name="livro_stt")
private int livrostt;

@ManyToOne
@JoinColumn(name="autor_id_autor", nullable = false)
private AutorLivro autor_id_autorfk;

@ManyToOne
@JoinColumn(name="genero_id_genero", nullable = false)
private GeneroLivro genero_id_generofk;

public GerenTitulos() {
}
// this.generos_id_genero_fk = generos_id_genero_fk;
public GerenTitulos(long id_livro, String titulo_livro, int quantidade,
        int livrostt) {
    this.id_livro = id_livro;
    this.titulo_livro = titulo_livro;
    this.quantidade = quantidade;
    
    this.livrostt = 1;
}

public GerenTitulos(long id_livro, String titulo_livro, int quantidade, int livrostt, AutorLivro autor_id_autorfk,
        GeneroLivro genero_id_generofk) {
    this.id_livro = id_livro;
    this.titulo_livro = titulo_livro;
    this.quantidade = quantidade;
    this.livrostt = livrostt;
    this.autor_id_autorfk = autor_id_autorfk;
    this.genero_id_generofk = genero_id_generofk;
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

public int getLivrostt() {
    return livrostt;
}

public void setLivrostt(int livrostt) {
    this.livrostt = livrostt;
}
public AutorLivro getAutor_id_autorfk() {
    return autor_id_autorfk;
}
public void setAutor_id_autorfk(AutorLivro autor_id_autorfk) {
    this.autor_id_autorfk = autor_id_autorfk;
}
public GeneroLivro getGenero_id_generofk() {
    return genero_id_generofk;
}
public void setGenero_id_generofk(GeneroLivro genero_id_generofk) {
    this.genero_id_generofk = genero_id_generofk;
}

}
