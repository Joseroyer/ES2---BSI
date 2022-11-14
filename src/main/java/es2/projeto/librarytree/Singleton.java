package es2.projeto.librarytree;

import es2.projeto.librarytree.models.Bibliotecario;
import es2.projeto.librarytree.models.Editora;
import es2.projeto.librarytree.models.Parametrizacao;
import es2.projeto.librarytree.repositories.BibliotecarioRepository;
import es2.projeto.librarytree.repositories.GerenEditoraRepository;
import es2.projeto.librarytree.repositories.ParametrizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Scope("singleton")
public class Singleton {


    @Autowired
    ParametrizacaoRepository parametrizacaoRepository;
    @Autowired
    GerenEditoraRepository editoraRepository;

    @Autowired
    BibliotecarioRepository bibliotecarioRepository;

    public Parametrizacao SalvarParam(Parametrizacao parametrizacao) {
        List<Parametrizacao> params = parametrizacaoRepository.findAll();
        if (params.isEmpty())
            this.parametrizacaoRepository.save(parametrizacao);
        else {
            Parametrizacao p = new Parametrizacao();
            p.setNome_empresa(parametrizacao.getNome_empresa());
            p.setImagem(parametrizacao.getImagem());
            p.setId(params.get(0).getId());
            p.setCidade(parametrizacao.getCidade());            
            p.setEstado(parametrizacao.getEstado());            
            p.setCnpj(parametrizacao.getCnpj());

            this.parametrizacaoRepository.save(p);
        }
        return parametrizacao;
    }

    public List<Parametrizacao> buscaParametros()
    {
        List <Parametrizacao> params = parametrizacaoRepository.findAll();
        return params;
    }

    public List<Parametrizacao> buscarEstilo()
    {
        List <Parametrizacao> params = parametrizacaoRepository.findAll();
        return params;
    }

    public List<Editora> buscarTodas() 
    {
        List<Editora> editora = editoraRepository.find();
        return editora;
    }
    
    public List<Editora> buscaFiltro(String filtro) 
    {
        String fil = filtro.toUpperCase();
        List<Editora> editora = editoraRepository.findAllWithFilter(fil);
        return editora;
    }

    public Editora excluirEditora(Editora id) {
        
        Optional<Editora> editora = editoraRepository.findById(id.getId_editora());
        id.setId_editora(editora.get().getId_editora());
        id.setNome_editora(editora.get().getNome_editora());
        id.setStatus(0);
        return this.editoraRepository.save(id);
    }

    public Editora editarEditora(Editora Identificador, String Nome) 
    {
        Optional<Editora> editora = editoraRepository.findById(Identificador.getId_editora());
        Identificador.setId_editora(editora.get().getId_editora());
        Identificador.setNome_editora(Nome);
        Identificador.setStatus(1);
        return this.editoraRepository.save(Identificador);
    }

    public Editora salvarEditora(Editora editora)
    {
        Editora editor = new Editora();
        String fil = editora.getNome_editora().toUpperCase();
        List<Editora> edit = editoraRepository.findAllWithFilter(fil);
        if(edit.isEmpty())
           return this.editoraRepository.save(editora);
       else 
           return editor;
    }

    public List<Bibliotecario> buscarTodosUsers() {
        
        List <Bibliotecario> bibli = bibliotecarioRepository.findAll();
        
        return bibli;
    }

    public Bibliotecario aprovar(Bibliotecario id) {
        
        Optional<Bibliotecario> bibli = bibliotecarioRepository.findById(id.getId());
        id.setStatus(1);
        id.setCPF(bibli.get().getCPF());
        id.setData_admissao(bibli.get().getData_admissao());
        id.setData_demissao(bibli.get().getData_demissao());
        id.setEmail(bibli.get().getEmail());
        id.setId(bibli.get().getId());
        id.setLogin(bibli.get().getLogin());
        id.setNivel(bibli.get().getNivel());
        id.setNome(bibli.get().getNome());
        id.setSenha(bibli.get().getSenha());
        id.setTelefone(bibli.get().getTelefone());
        return this.bibliotecarioRepository.save(id);

    }
}
