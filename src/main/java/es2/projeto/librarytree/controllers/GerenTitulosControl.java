package es2.projeto.librarytree.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import es2.projeto.librarytree.repositories.GerenTitulosRepository;
import org.springframework.web.bind.annotation.RequestMethod;


import es2.projeto.librarytree.models.GerenTitulos;
import es2.projeto.librarytree.repositories.GerenTitulosRepository;

@RestController
@RequestMapping("/apis")
public class GerenTitulosControl {
    @Autowired
    GerenTitulosRepository gerenTitulosRepository;

    @RequestMapping("/listar-titulos")
    public ResponseEntity <Object> todos(){
        List <Titulos> titulos = gerenTitulosRepository.find();
        return new ResponseEntity<>(titulos,HttpStatus.OK);
    }

    @RequestMapping("/listar-um-titulo")
    public ResponseEntity<Object> buscarFiltro(@RequestParam(value="filtro")String filtro)
    {
        String filtrar = filtro.toUpperCase();
        List <Titulos> titulos = gerenTitulosRepository.findAllWithFilter(filtrar);
        return new ResponseEntity<>(titulos,HttpStatus.OK);
    }
    
    @RequestMapping("/excluir-titulo")
    public Titulos exclutit(@RequestParam(value="id")Titulos id)
    {
        Optional<Titulos> titulos = gerenTitulosRepository.findById(id.getId_livro());
        id.setId_livro(livro.get().getId_livro());
        id.Nome_titulo(livro.get().getNome_Livro());
        id.setStatus(0);
        return this.gerenTitulosRepository.save(id);
    }
    
    @RequestMapping("/editar-titulos-gerenciados")
    public Titulos edittit(@RequestParam(value="Identificador") Titulos Identificador, @RequestParam(value="Nome")String Nome)
    {
        Optional<Titulos> titulos = gerenTitulosRepository.findById(Identificador.getId_livro());
        Identificador.setId_livro(livro.get().getId_livro());
        Identificador.Nome_titulo(Nome);
        Identificador.setStatus(1);
        return this.gerenTitulosRepository.save(Identificador);
    }

    @PostMapping("/CadastrarNovosTitulos")
    public Titulos CadastrarNovosTitulos(@RequestBody Titulos titulos){
        Titulos tit = new Titulos();
        String filtrar = titulos.getNome_Livro().toUpperCase();
        List <Titulos> titu = gerenTitulosRepository.findAllWithFilter(filtrar);
        if(titu.isEmpty())
            return this.gerenTitulosRepository.save(titulos);
        else    
            return tit;
            

    }



    
}
