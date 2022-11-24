package es2.projeto.librarytree.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "parcelamento")
public class Parcelamento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parc")
    private Long id_parc;

    @Column(name="valor_parc")
    private Double valor_parc;

    @Column(name="data_pagamento")
    private Date data_pagamento;
    
    @Column(name="data_venc_parcela")
    private LocalDate data_venc_parcela;

    @Column(name="emprestimo_cliente_id")
    private Long emprestimo_cliente_id;

    @Column(name="emprestimo_id_emprestimo")
    private Long emprestimo_id_emprestimo;

    
    public void setEmprestimo_cliente_id(Long emprestimo_cliente_id) {
        this.emprestimo_cliente_id = emprestimo_cliente_id;
    }

    public Long getEmprestimo_id_emprestimo() {
        return emprestimo_id_emprestimo;
    }

    public void setEmprestimo_id_emprestimo(Long emprestimo_id_emprestimo) {
        this.emprestimo_id_emprestimo = emprestimo_id_emprestimo;
    }

    

    public Parcelamento(Long id_parc, Double valor_parc, Date data_pagamento, LocalDate data_venc_parcela,
            Long emprestimo_cliente_id, Long emprestimo_id_emprestimo) {
        this.id_parc = id_parc;
        this.valor_parc = valor_parc;
        this.data_pagamento = data_pagamento;
        this.data_venc_parcela = data_venc_parcela;
        this.emprestimo_cliente_id = emprestimo_cliente_id;
        this.emprestimo_id_emprestimo = emprestimo_id_emprestimo;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId_parc() {
        return id_parc;
    }

    public void setId_parc(Long id_parc) {
        this.id_parc = id_parc;
    }

    public Double getValor_parc() {
        return valor_parc;
    }

    public void setValor_parc(Double valor_parc) {
        this.valor_parc = valor_parc;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public LocalDate getData_venc_parcela() {
        return data_venc_parcela;
    }

    public void setData_venc_parcela(LocalDate data_venc_parcela) {
        this.data_venc_parcela = data_venc_parcela;
    }

    public Parcelamento() {
    }


    

    


    
}
