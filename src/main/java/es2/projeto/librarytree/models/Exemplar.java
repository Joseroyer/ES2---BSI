package es2.projeto.librarytree.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exemplares")
public class Exemplar 
{
    @Id
    @Column(name = "id_exemplar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_exemplar;

    @Column(name = "qtde")
    private int qtde;

    @Column(name = "ano_publicado")
    private Date ano_publicado;

    @Column(name = "qtd_dias_empres")
    private int qtd_dias_empres;

    @ManyToOne
    @JoinColumn(name = "livro_id_livro")
    private Livro livro_id_livro;

    @ManyToOne
    @JoinColumn(name = "editora_id_editora")
    private Editora editora_id_editora;

    @Column(name="status")
    private int status;



    public Long getId_exemplar() {
        return id_exemplar;
    }

    public void setId_exemplar(Long id_exemplar) {
        this.id_exemplar = id_exemplar;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public Date getAno_publicado() {
        return ano_publicado;
    }

    public void setAno_publicado(Date ano_publicado) {
        this.ano_publicado = ano_publicado;
    }

    public int getQtd_dias_empres() {
        return qtd_dias_empres;
    }

    public void setQtd_dias_empres(int qtd_dias_empres) {
        this.qtd_dias_empres = qtd_dias_empres;
    }

    public Livro getLivro_id_livro() {
        return livro_id_livro;
    }

    public void setLivro_id_livro(Livro livro_id_livro) {
        this.livro_id_livro = livro_id_livro;
    }

    public Editora getEditora_id_editora() {
        return editora_id_editora;
    }

    public void setEditora_id_editora(Editora editora_id_editora) {
        this.editora_id_editora = editora_id_editora;
    }

    public Exemplar(Long id_exemplar, int qtde, Date ano_publicado, int qtd_dias_empres, Livro livro_id_livro,
            Editora editora_id_editora, int status) {
        this.id_exemplar = id_exemplar;
        this.qtde = qtde;
        this.ano_publicado = ano_publicado;
        this.qtd_dias_empres = qtd_dias_empres;
        this.livro_id_livro = livro_id_livro;
        this.editora_id_editora = editora_id_editora;
        this.status = status;
    }

    public Exemplar() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }   
    
}
