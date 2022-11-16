package es2.projeto.librarytree.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es2.projeto.librarytree.Singleton;
import es2.projeto.librarytree.models.Editora;
import es2.projeto.librarytree.repositories.GerenEditoraRepository;


@RestController
@RequestMapping("/apis")

public class EditoraRestControl {
    
    @Autowired
    GerenEditoraRepository editoraRepository; 

    @Autowired
    Singleton singleton;
    
    @RequestMapping("/listar-todas-editoras")
    public ResponseEntity <Object> buscarTodas()
    {   
        List<Editora> editora = singleton.buscarTodas();
        return new ResponseEntity<>(editora,HttpStatus.OK);

    }

    @RequestMapping("/listar-editora")
    public ResponseEntity <Object> buscarFiltro(@RequestParam(value = "filtro")String filtro)
    {   
        List<Editora> editora = singleton.buscaFiltro(filtro);
        return new ResponseEntity<>(editora,HttpStatus.OK);
    }

    // @RequestMapping("/listar-atributos")
    // public ResponseEntity <Object> buscarAtributos(@RequestParam(value = "id")int id)
    // {   
    //     List<Editora> editora = singleton.buscarById(id);
    //     return new ResponseEntity<>(editora,HttpStatus.OK);
    // }
    @RequestMapping("/excluir")
    public Editora excluir(@RequestParam(value = "id")Editora id)
    {   
        Editora edit = new Editora();
        edit = singleton.excluirEditora(id);
        return edit;
        
    }

    @RequestMapping("/editar")
    public Editora editar(@RequestParam(value="Identificador") Editora Identificador, @RequestParam(value="Nome") String Nome)
    {   
        
        Editora edit = new Editora();
        edit = singleton.editarEditora(Identificador, Nome);
        return edit;
    }

    @PostMapping("/cadEditora")
    public Editora cadEditora(@RequestBody Editora editora)
    {
        Editora edit = new Editora();
        edit = singleton.salvarEditora(editora);
        return edit;
    }

}
