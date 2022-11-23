package es2.projeto.librarytree.singleton;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import es2.projeto.librarytree.models.Emprestimo;
import es2.projeto.librarytree.models.Parcelamento;

import es2.projeto.librarytree.repositories.DevolucaoRepository;
import es2.projeto.librarytree.repositories.ParcelamentoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Scope("singleton")
public class SingletonDevolucao 
{
    
    private final DevolucaoRepository devolucaoRepository;

    private final ParcelamentoRepository parcelamentoRepository;

    public List<Emprestimo> buscarTodas() {
        List<Emprestimo> ee = devolucaoRepository.findExemplar();
        return ee;
    }

    public Emprestimo devolverExemplar(Emprestimo id) {
        Optional<Emprestimo> emp = devolucaoRepository.findById(id.getId_emprestimo());
        id.setId_emprestimo(emp.get().getId_emprestimo());
        id.setCliente(emp.get().getCliente());
        id.setData_devolucao(emp.get().getData_devolucao());
        id.setData_emprestimo(emp.get().getData_emprestimo());
        id.setExemplar_id(emp.get().getExemplar_id());
        id.setForma_pagamento(emp.get().getForma_pagamento());
        id.setQtde_parcelas(emp.get().getQtde_parcelas());
        id.setStatus(1);
        return this.devolucaoRepository.save(id);
    }

    public List<Emprestimo> buscarfiltro(String filtro) {
        List<Emprestimo> ee = devolucaoRepository.findExemplarFiltro(filtro);
        return ee;
    }

    public es2.projeto.librarytree.models.Parcelamento Parcelamento(Emprestimo e)
    {
        
        Parcelamento p = new Parcelamento();
        LocalDate date = LocalDate.now();
        date.plusMonths(1);
        p.setData_venc_parcela(date);
        p.setData_pagamento(null);
        p.setEmprestimo_cliente_id(e.getCliente().getId());
        p.setEmprestimo_id_emprestimo(e.getId_emprestimo());
        p.setValor_parc(e.getValor()/e.getQtde_parcelas());
        return this.parcelamentoRepository.save(p);
    }
    public Emprestimo pagar(Emprestimo identificador, String num, String qtd) {
        Optional<Emprestimo> emp = devolucaoRepository.findById(identificador.getId_emprestimo());
        if(num == "")
            num ="PIX";
        else
            num = "Cartão de Crédito";      
        identificador.setId_emprestimo(emp.get().getId_emprestimo());
        identificador.setCliente(emp.get().getCliente());
        identificador.setData_devolucao(emp.get().getData_devolucao());
        identificador.setData_emprestimo(emp.get().getData_emprestimo());
        identificador.setExemplar_id(emp.get().getExemplar_id());
        identificador.setForma_pagamento(num);
        identificador.setQtde_parcelas(Integer.parseInt(qtd));
        identificador.setStatus(1);
        identificador.setValor(50.00);
        return this.devolucaoRepository.save(identificador);
    }

}
