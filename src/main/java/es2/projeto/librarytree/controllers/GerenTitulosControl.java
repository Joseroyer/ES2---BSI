package es2.projeto.librarytree.controllers;
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
import es2.projeto.librarytree.repositories.GerenTitulosRepository;
import es2.projeto.librarytree.models.GerenTitulos;
import es2.projeto.librarytree.repositories.GerenTitulosRepository;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpRange;

@RestController
@RequestMapping("/apis")
public class GerenTitulosControl {
    @Autowired
    GerenTitulosRepository gerenTitulosRepository;

    @RequestMapping("/listar-titulos")//lista todos 
    public ResponseEntity <Object> todos(){
        List <GerenTitulos> titulos = gerenTitulosRepository.find();
        return new ResponseEntity<>(titulos,HttpStatus.OK);
    }

    @RequestMapping("/listar-um-titulo")//lista só um
    public ResponseEntity<Object> buscarFiltro(@RequestParam(value="filtro")String filtro)
    {
        String filtrar = filtro.toUpperCase();
        List <GerenTitulos> titulos = gerenTitulosRepository.findAllWithFilter(filtrar);
        return new ResponseEntity<>(titulos,HttpStatus.OK);
    }
    
    @RequestMapping("/excluir-titulo")
    public GerenTitulos exclutit(@RequestParam(value="id")GerenTitulos id)
    {
        Optional<GerenTitulos> titulos = gerenTitulosRepository.findById(id.getId_livro());
        id.setId_livro(titulos.get().getId_livro());
        id.setTitulo_livro(titulos.get().getTitulo_livro());
        id.setLivrostt(0);
        return this.gerenTitulosRepository.save(id);
    }
    
    @RequestMapping("/editar-titulos-gerenciados")
    public GerenTitulos edittit(@RequestParam(value="Identificador") GerenTitulos Identificador, @RequestParam(value="ttlivro")String ttlivro)
    {
        Optional<GerenTitulos> titulos = gerenTitulosRepository.findById(Identificador.getId_livro());
        Identificador.setId_livro(titulos.get().getId_livro());
        Identificador.setTitulo_livro(ttlivro);
        Identificador.setLivrostt(1);
        return this.gerenTitulosRepository.save(Identificador);
    }



    @PostMapping("/CadastrarNovosTitulos")
    public GerenTitulos createTitulos(@RequestBody GerenTitulos titulos) {

        titulos.setTitulo_livro(titulos.getTitulo_livro().toLowerCase());
        return this.gerenTitulosRepository.save(titulos);
    }
    // @PostMapping("/CadastrarNovosTitulos")
    // public GerenTitulos CadastrarNovosTitulos(@RequestBody GerenTitulos titulos){
    //     GerenTitulos tit = new GerenTitulos();
    //     String filtrar = titulos.getTitulo_livro().toUpperCase();
    //     List <GerenTitulos> titu = gerenTitulosRepository.findAllWithFilter(filtrar);
    //     if(titu.isEmpty())
    //         return this.gerenTitulosRepository.save(titulos);
    //     else    
    //         return tit;
    // }



    
}
