package es2.projeto.librarytree.singleton;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es2.projeto.librarytree.models.Exemplares;
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

    public ResponseEntity<Object> saveExemplar(Exemplares exemplares) {
        exemplares.setStatus(1);
        return new ResponseEntity<>(exemplaresRepository.save(exemplares), HttpStatus.CREATED);
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

    public Exemplares editarExemplares(es2.projeto.librarytree.models.Exemplares identificador, int Quantidade,
            Date data) {
        Optional<Exemplares> ex = exemplaresRepository.findById(identificador.getId());
        identificador.setId(ex.get().getId());
        identificador.setAno_publicado(ex.get().getAno_publicado());
        identificador.setQtd(ex.get().getQtd());
        return this.exemplaresRepository.save(identificador);
    }

    public Optional<Exemplares> buscarExemplar(Long id) {
        Optional<Exemplares> bi = exemplaresRepository.findById(id);
        return bi;
    }

}
