package es2.projeto.librarytree.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "emprestimoexemplar")
public class EmprestimoExemplar implements Serializable {

    private static final long serialVersionUID = 1L;
    

    @Column(name="qtde")
    private int qtde;

    @Column(name="renovacao_entrega")
    private Date renovacao_entrega;

    @Column(name="emprestimo_id_empr")
    private int emprestimo_id_empr;

    @Column(name="emprestimo_cli_id")
    private int emprestimo_cli_id;

    @Column(name="emprestimo_id_exemplar")
    private int emprestimo_id_exemplar;

    @Id
    @Column(name = "id_emprEx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_emprEx;

    
    
    public EmprestimoExemplar() {
    }

    
    public EmprestimoExemplar(int qtde, Date renovacao_entrega, int emprestimo_id_empr, int emprestimo_cli_id,
            int emprestimo_id_exemplar, Long id_emprEx) {
        this.qtde = qtde;
        this.renovacao_entrega = renovacao_entrega;
        this.emprestimo_id_empr = emprestimo_id_empr;
        this.emprestimo_cli_id = emprestimo_cli_id;
        this.emprestimo_id_exemplar = emprestimo_id_exemplar;
        this.id_emprEx = id_emprEx;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public Date getRenovacao_entrega() {
        return renovacao_entrega;
    }

    public void setRenovacao_entrega(Date renovacao_entrega) {
        this.renovacao_entrega = renovacao_entrega;
    }

    public int getEmprestimo_id_empr() {
        return emprestimo_id_empr;
    }

    public void setEmprestimo_id_empr(int emprestimo_id_empr) {
        this.emprestimo_id_empr = emprestimo_id_empr;
    }

    public int getEmprestimo_cli_id() {
        return emprestimo_cli_id;
    }

    public void setEmprestimo_cli_id(int emprestimo_cli_id) {
        this.emprestimo_cli_id = emprestimo_cli_id;
    }

    public int getEmprestimo_id_exemplar() {
        return emprestimo_id_exemplar;
    }

    public void setEmprestimo_id_exemplar(int emprestimo_id_exemplar) {
        this.emprestimo_id_exemplar = emprestimo_id_exemplar;
    }

    public Long getId_emprEx() {
        return id_emprEx;
    }

    public void setId_emprEx(Long id_emprEx) {
        this.id_emprEx = id_emprEx;
    }

    

}
    
