package es2.projeto.librarytree.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor //cria construtor
@Data // gera get e set
public class usuario {
    private Long id;
    private String nome;
    private String senha;
    private String data_nasc;
    private String CPF;
    private String telefone;

}
