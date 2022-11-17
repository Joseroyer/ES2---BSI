package es2.projeto.librarytree.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "autor")
public class AutorLivro {
@Id
@Column(name="autor_id")
private String autorid;

@Column(name="autor_nome")
private String autornome;

public AutorLivro() {
}

public AutorLivro(String autorid, String autornome) {
    this.autorid = autorid;
    this.autornome = autornome;
}

public String getAutorid() {
    return autorid;
}

public void setAutorid(String autorid) {
    this.autorid = autorid;
}

public String getAutornome() {
    return autornome;
}

public void setAutornome(String autornome) {
    this.autornome = autornome;
}

}
