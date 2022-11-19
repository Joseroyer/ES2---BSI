package es2.projeto.librarytree.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es2.projeto.librarytree.models.Parametrizacao;
import es2.projeto.librarytree.singleton.SingletonParametrizacao;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/apis")
public class ParametrizacaoControl {

    private final SingletonParametrizacao singleton;

    @RequestMapping(value = "/testar-param")
    public ResponseEntity<Object> buscarTodos() {

        List<Parametrizacao> parameters = singleton.buscaParametros();
        if (parameters.isEmpty())
            return new ResponseEntity<>("Não", HttpStatus.OK);
        else
            return new ResponseEntity<>(parameters, HttpStatus.OK);
    }

    @RequestMapping(value = "/estilo")
    public ResponseEntity<Object> buscarestilo() {
        List<Parametrizacao> parameters = singleton.buscarEstilo();
        return new ResponseEntity<>(parameters, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/salvar")
    public void Salvar(@RequestBody Parametrizacao parametrizacao) {
        singleton.SalvarParam(parametrizacao);
    }

}
