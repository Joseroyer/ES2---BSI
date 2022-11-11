package es2.projeto.librarytree.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import es2.projeto.librarytree.repositories.ParametrizacaoRepository;


@Entity
@Table(name = "parametrizacao")
public class Parametrizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    @Column(name = "nome_empresa")
    private String nome_empresa;

    @Column(name = "imagem")
    private String imagem;
    

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    

    public Parametrizacao(String nome_empresa, String imagem) {
        this.nome_empresa = nome_empresa;
        this.imagem = imagem;
    }

    public Parametrizacao() {
    }

    // public int getLogotipo() {
    //     return logotipo;
    // }

    // public void setLogotipo(int logotipo) {
    //     this.logotipo = logotipo;
    // }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void Salvar(Parametrizacao parametrizacao) 
    {
        Metodos m = new Metodos();
        m.Salvar(parametrizacao);
    }

    // public String getLogotipo() {
    //     return logotipo;
    // }

    // public void setLogotipo(String logotipo) {
    //     this.logotipo = logotipo;
    // }

    // public byte[] getLogotipo() {
    //     return logotipo;
    // }

    // public void setLogotipo(byte[] logotipo) {
    //     this.logotipo = logotipo;
    // }
    class Metodos
{

    @Autowired
    ParametrizacaoRepository parametrizacaoRepository;

    public Parametrizacao Salvar(Parametrizacao parametrizacao)
    {
        List <Parametrizacao> params = parametrizacaoRepository.findAll();
        if(params.isEmpty())
            this.parametrizacaoRepository.save(parametrizacao);
        else
        {
            Parametrizacao p = new Parametrizacao();
            p.setNome_empresa(parametrizacao.getNome_empresa());
            p.setImagem(parametrizacao.getImagem());
            p.setId(params.get(0).getId());
            this.parametrizacaoRepository.save(p);
        }

        return parametrizacao;
    }
}

}



