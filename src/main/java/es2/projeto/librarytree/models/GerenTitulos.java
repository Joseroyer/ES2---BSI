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


@Column(name="generos_id_genero")
private String genero_id_generofk;

@Column(name="autor_autor_nome")
private String autor_autor_nome;

public GerenTitulos() {
}

public GerenTitulos(long id_livro, String titulo_livro, int quantidade, int livrostt, String genero_id_generofk,
        String autor_autor_nome) {
    this.id_livro = id_livro;
    this.titulo_livro = titulo_livro;
    this.quantidade = quantidade;
    this.livrostt = 1;
    this.genero_id_generofk = genero_id_generofk;
    this.autor_autor_nome = autor_autor_nome;
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


public String getAutor_autor_nome() {
    return autor_autor_nome;
}
public void setAutor_autor_nome(String autor_autor_nome) {
    this.autor_autor_nome = autor_autor_nome;
}
public String getGenero_id_generofk() {
    return genero_id_generofk;
}
public void setGenero_id_generofk(String genero_id_generofk) {
    this.genero_id_generofk = genero_id_generofk;
}

}
