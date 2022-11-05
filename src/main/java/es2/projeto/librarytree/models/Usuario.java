package es2.projeto.librarytree.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor //cria construtor
@Data // gera get e set
public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String CPF;
    private String telefone;
}
