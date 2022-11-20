package es2.projeto.librarytree.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "emprestimoexemplar")
public class EmprestimoExemplar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_emprEx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_emprEx;

    @Column(name = "qtde")
    private int qtde;
    
    @Column(name = "renovacao_entrega")
    private Date renovacao_entrega;

    @ManyToOne
    @JoinColumn(name="emprestimo_id_empr", nullable=false)
    private Emprestimo emprestimo;

    @ManyToOne
    @JoinColumn(name="emprestimo_cli_id", nullable=false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="emprestimo_id_exemplar", nullable=false)
    private Exemplar emprestimo_id_exemplar;

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public Date getRenovacao_entrega() {
        return renovacao_entrega;
    }

    
    

    public EmprestimoExemplar(int qtde, Date renovacao_entrega, Emprestimo emprestimo, Cliente cliente,
            Exemplar emprestimo_id_exemplar) {
        this.qtde = qtde;
        this.renovacao_entrega = renovacao_entrega;
        this.emprestimo = emprestimo;
        this.cliente = cliente;
        this.emprestimo_id_exemplar = emprestimo_id_exemplar;
    }

    public EmprestimoExemplar() {
    }

    public void setRenovacao_entrega(Date renovacao_entrega) {
        this.renovacao_entrega = renovacao_entrega;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Exemplar getEmprestimo_id_exemplar() {
        return emprestimo_id_exemplar;
    }

    public void setEmprestimo_id_exemplar(Exemplar emprestimo_id_exemplar) {
        this.emprestimo_id_exemplar = emprestimo_id_exemplar;
    }
    

    
}
    
