package es2.projeto.librarytree.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es2.projeto.librarytree.models.Editora;
import es2.projeto.librarytree.repositories.GerenEditoraRepository;


@RestController
@RequestMapping("/apis")

public class EditoraRestController {
    
    @Autowired
    GerenEditoraRepository editoraRepository; 
    
    @RequestMapping("/listar-todas-editoras")
    public ResponseEntity <Object> buscarTodas()
    {   
        List<Editora> editora = editoraRepository.find();
        return new ResponseEntity<>(editora,HttpStatus.OK);
    }

    @RequestMapping("/listar-editora")
    public ResponseEntity <Object> buscarFiltro(@RequestParam(value = "filtro")String filtro)
    {   
        String fil = filtro.toUpperCase();
        List<Editora> editora = editoraRepository.findAllWithFilter(fil); 
        return new ResponseEntity<>(editora,HttpStatus.OK);
    }

    @RequestMapping("/excluir")
    public Editora excluir(@RequestParam(value = "id")Editora id)
    {   

        Optional<Editora> editora = editoraRepository.findById(id.getId_editora());
        id.setId_editora(editora.get().getId_editora());
        id.setNome_editora(editora.get().getNome_editora());
        id.setStatus(0);
        return this.editoraRepository.save(id);
    }

    @RequestMapping("/editar")
    public Editora editar(@RequestParam(value="Identificador") Editora Identificador, @RequestParam(value="Nome") String Nome)
    {   
        
        Optional<Editora> editora = editoraRepository.findById(Identificador.getId_editora());
    
        Identificador.setId_editora(editora.get().getId_editora());
        Identificador.setNome_editora(Nome);
        Identificador.setStatus(1);
        return this.editoraRepository.save(Identificador);
    }

    @PostMapping("/cadEditora")
    public Editora cadEditora(@RequestBody Editora editora)
    {
        Editora editor = new Editora();
        String fil = editora.getNome_editora().toUpperCase();
        List<Editora> edit = editoraRepository.findAllWithFilter(fil);
        if(edit.isEmpty())
           return this.editoraRepository.save(editora);
       else 
           return editor;
    }

}
