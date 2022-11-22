package es2.projeto.librarytree.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "emprestimo")
public class Emprestimo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emprestimo")
    private Long id_emprestimo;

    @Column(name = "data_emprestimo")
    private Date data_emprestimo;

    @Column(name = "data_devolucao")
    private Date data_devolucao;

    @Column(name = "forma_pagamento")
    private String forma_pagamento;

    @Column(name = "valor")
    private double valor;

    @Column(name = "qtde_parcelas")
    private int qtde_parcelas;

    @ManyToOne
    @JoinColumn(name="cliente_id", nullable=false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="exemplar_id", nullable=false)
    private Exemplar exemplar_id;
    
    @Column(name = "status")
    private int status;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    

    public Long getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(Long id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public Date getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(Date data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtde_parcelas() {
        return qtde_parcelas;
    }

    public void setQtde_parcelas(int qtde_parcelas) {
        this.qtde_parcelas = qtde_parcelas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Emprestimo() {
    }

    public Emprestimo(Long id_emprestimo, Date data_emprestimo, Date data_devolucao, String forma_pagamento,
            double valor, int qtde_parcelas, Cliente cliente, Exemplar exemplar_id, int status) {
        this.id_emprestimo = id_emprestimo;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
        this.forma_pagamento = "";
        this.valor = 0;
        this.qtde_parcelas = 0;
        this.cliente = cliente;
        this.exemplar_id = exemplar_id;
        this.status = 1;
    }

    public Exemplar getExemplar_id() {
        return exemplar_id;
    }

    public void setExemplar_id(Exemplar exemplar_id) {
        this.exemplar_id = exemplar_id;
    }



    public int getStatus() {
        return status;
    }



    public void setStatus(int status) {
        this.status = status;
    }

      
    
}