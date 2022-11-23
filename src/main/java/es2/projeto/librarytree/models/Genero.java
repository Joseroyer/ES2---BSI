package es2.projeto.librarytree.models;

import javax.persistence.*;

@Entity
@Table(name = "generos")
public class Genero {
    
    @Id
    @Column(name = "id_genero")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_genero;

    @Column(name="tipo_genero")
    private String tipo_genero;

    public Long getId_genero() {
        return id_genero;
    }

    public void setId_genero(Long id_genero) {
        this.id_genero = id_genero;
    }

    public String getTipo_genero() {
        return tipo_genero;
    }

    public void setTipo_genero(String tipo_genero) {
        this.tipo_genero = tipo_genero;
    }

    public Genero(Long id_genero, String tipo_genero) {
        this.id_genero = id_genero;
        this.tipo_genero = tipo_genero;
    }

    public Genero()
    {}
}
