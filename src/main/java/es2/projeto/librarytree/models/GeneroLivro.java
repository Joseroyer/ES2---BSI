package es2.projeto.librarytree.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="generos")
public class GeneroLivro {
    @Id
    @Column(name="id_genero")
    private String idgenero;

    @Column(name = "tipo_genero")
    private String tpgenero;

    public GeneroLivro() {
    }

    public GeneroLivro(String idgenero, String tpgenero) {
        this.idgenero = idgenero;
        this.tpgenero = tpgenero;
    }

    public String getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(String idgenero) {
        this.idgenero = idgenero;
    }

    public String getTpgenero() {
        return tpgenero;
    }

    public void setTpgenero(String tpgenero) {
        this.tpgenero = tpgenero;
    }

    


}
