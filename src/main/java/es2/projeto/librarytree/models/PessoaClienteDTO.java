package es2.projeto.librarytree.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PessoaClienteDTO {
    private PessoaFisica pessoaFisica;
    private Cliente cliente;
}
