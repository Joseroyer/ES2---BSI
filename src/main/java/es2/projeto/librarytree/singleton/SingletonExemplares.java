package es2.projeto.librarytree.singleton;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import es2.projeto.librarytree.models.Editora;
import es2.projeto.librarytree.models.Exemplares;
import es2.projeto.librarytree.models.Genero;
import es2.projeto.librarytree.models.Livro;
import es2.projeto.librarytree.repositories.ExemplaresRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Scope("singleton")
public class SingletonExemplares {
    private final ExemplaresRepository exemplaresRepository;

    public List<Exemplares> findAllExemplar() {
        return exemplaresRepository.findAllExemplar();
    }

    public Exemplares saveExemplar(Exemplares exemplares) {
        Livro livro = new Livro();
        Editora editora = new Editora();
        Genero genero = new Genero();
        livro.setId(exemplares.getLivro_fk().getId());
        livro.setTitulo(exemplares.getLivro_fk().getTitulo());
        livro.setQuantidade(exemplares.getLivro_fk().getQuantidade());
        genero.setId(exemplares.getLivro_fk().getGenero_fk().getId());
        genero.setGenero(exemplares.getLivro_fk().getGenero_fk().getGenero());
        livro.setGenero_fk(genero);
        exemplares.setLivro_fk(livro);
        editora.setId_editora(exemplares.getEditora_fk().getId_editora());
        editora.setNome_editora(exemplares.getEditora_fk().getNome_editora());
        editora.setCidade_editora(exemplares.getEditora_fk().getCidade_editora());
        editora.setEstado_editora(exemplares.getEditora_fk().getEstado_editora());
        editora.setStatus(exemplares.getEditora_fk().getStatus());
        exemplares.setEditora_fk(editora);
        System.out.println(exemplares);
        return exemplaresRepository.save(exemplares);
    }

    public Exemplares excluirExemplares(Exemplares id) {
        Optional<Exemplares> bibli = exemplaresRepository.findById(id.getId());
        id.setStatus(0);
        id.setId(bibli.get().getId());
        id.setLivro_fk(bibli.get().getLivro_fk());
        id.setEditora_fk(bibli.get().getEditora_fk());
        id.setQtd(bibli.get().getQtd());
        id.setAno_publicado(bibli.get().getAno_publicado());
        return this.exemplaresRepository.save(id);
    }

}