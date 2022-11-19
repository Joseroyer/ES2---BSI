package es2.projeto.librarytree.singleton;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import es2.projeto.librarytree.models.Editora;
import es2.projeto.librarytree.repositories.GerenEditoraRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Scope("singleton")
public class SingletonEditora {

    private final GerenEditoraRepository editoraRepository;

    public List<Editora> buscarTodas() {
        List<Editora> editora = editoraRepository.find();
        return editora;
    }

    public List<Editora> buscaFiltro(String filtro) {
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

    public Editora editarEditora(Editora Identificador, String Nome, String Cidade, String Estado) {
        // Editora editor = new Editora();
        // String fil = Identificador.getNome_editora().toUpperCase();
        // List<Editora> edit = editoraRepository.findAllWithFilter(fil);
        // if(edit.isEmpty())
        // {

        Optional<Editora> editora = editoraRepository.findById(Identificador.getId_editora());
        Identificador.setId_editora(editora.get().getId_editora());
        Identificador.setNome_editora(Nome);
        Identificador.setStatus(1);
        Identificador.setCidade_editora(Cidade);
        Identificador.setEstado_editora(Estado);
        return this.editoraRepository.save(Identificador);

    }

    public Editora salvarEditora(Editora editora) {
        Editora editor = new Editora();
        String fil = editora.getNome_editora().toUpperCase();
        List<Editora> edit = editoraRepository.findAllWithFilter(fil);
        if (edit.isEmpty())
            return this.editoraRepository.save(editora);
        else
            return editor;
    }

    public Optional<Editora> buscarEditora(Long id) {
        Optional<Editora> ed = editoraRepository.findById(id);
        return ed;
    }
}
