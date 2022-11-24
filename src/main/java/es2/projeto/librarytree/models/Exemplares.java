package es2.projeto.librarytree.models;

import java.util.Date;

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
@Table(name = "exemplares")
public class Exemplares {

    @Id
    @Column(name = "id_exemplar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "qtde")
    private int qtd;

    @Column(name = "ano_publicado")
    private Date ano_publicado;

    @Column(name = "qtd_dias_empres")
    private int qtd_dias_empres;

    @ManyToOne
    @JoinColumn(name = "livro_id_livro")
    private Livro livro_fk;

    @ManyToOne
    @JoinColumn(name = "editora_id_editora")
    private Editora editora_fk;

    @Column(name = "status")
    private int status;

    public Exemplares() {
    }

    public Exemplares(Long id) {
        this.id = id;
    }

    public Exemplares(int qtd, Date ano_publicado, int qtd_dias_empres, Livro livro_fk, Editora editora_fk,
            int status) {
        this.ano_publicado = ano_publicado;
        this.qtd_dias_empres = qtd_dias_empres;
        this.livro_fk = livro_fk;
        this.editora_fk = editora_fk;
        this.status = status;
    }

}
