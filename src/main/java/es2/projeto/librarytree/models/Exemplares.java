package es2.projeto.librarytree.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
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

    @Column(name ="status")
    private int status;

    public Exemplares(int qtd, Date ano_publicado, int qtd_dias_empres, Livro livro_fk, Editora editora_fk,
            int status) {
        this.ano_publicado = ano_publicado;
        this.qtd_dias_empres = qtd_dias_empres;
        this.livro_fk = livro_fk;
        this.editora_fk = editora_fk;
        this.status = status;
    }

    


}
