package es2.projeto.librarytree.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es2.projeto.librarytree.models.Parametrizacao;
import es2.projeto.librarytree.singleton.SingletonParametrizacao;

@RestController
@RequestMapping(value = "/apis")
public class ParametrizacaoControl {

    @Autowired
    SingletonParametrizacao singleton;

    

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
