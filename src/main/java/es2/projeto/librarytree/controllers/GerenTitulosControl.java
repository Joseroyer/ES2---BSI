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
import es2.projeto.librarytree.models.GeneroLivro;
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


    @GetMapping("/listar-titulos")//lista todos 
    public ResponseEntity <Object> todos(){
       return new ResponseEntity<>(gerenTitulosRepository.findAll(),HttpStatus.OK);
        
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
      
      public GerenTitulos gerentit (@RequestParam(value="Identificador") GerenTitulos Identificador, @RequestParam(value="Nome") String Nome)
    {
    GerenTitulos gerenTitulo = new GerenTitulos();
      String fil = Identificador.getTitulo_livro().toUpperCase();
      {
          Optional<GerenTitulos> Tit = gerenTitulosRepository.findById(Identificador.getId_livro());
          Identificador.setId_livro(Tit.get().getId_livro());
          Identificador.setTitulo_livro(Nome);
          Identificador.setLivrostt(1);
          return this.gerenTitulosRepository.save(Identificador);
      }
  }

    @PostMapping("/CadastrarNovosTitulos")
    public ResponseEntity<Object> CadastrarNovoTitulo(@RequestBody GerenTitulos livro){
      // GeneroLivro gen = new GeneroLivro(Long.parseLong("1"),"Animais");
      livro.setLivrostt(1);
      return new ResponseEntity<>(gerenTitulosRepository.save(livro),HttpStatus.OK);
    }







    // @GetMapping("/listar-titulos")//lista todos 
    // public ResponseEntity <Object> todos(){
    //     List <GerenTitulos> titulos = gerenTitulosRepository.findAll();
    //     return new ResponseEntity<>(titulos,HttpStatus.OK);
        
    // }

    // @RequestMapping("/listar-um-titulo")//lista só um
    // public ResponseEntity<Object> buscarFiltro(@RequestParam(value="filtro")String filtro)
    // {
    //     String filtrar = filtro.toUpperCase();
    //     List <GerenTitulos> titulos = gerenTitulosRepository.findAllWithFilter(filtrar);
    //     return new ResponseEntity<>(titulos,HttpStatus.OK);
    // }
    

    


    // public ResponseEntity<Object> CadastrarNovoTitulo(@RequestBody GerenTitulos livro){
    //     // List <GerenTitulos> livros = livros.setTitulo_livro(livro.getTitulo_livro());
    //   return new ResponseEntity<>(gerenTitulosRepository.save(livro),HttpStatus.OK);
    // }



    // @PostMapping("/CadastrarNovosTitulos")
    // public GerenTitulos createTitulo(@RequestBody GerenTitulos titulo) {
    //     titulo.setTitulo_livro(titulo.getTitulo_livro().toLowerCase());
    //     return this.gerenTitulosRepository.save(titulo);
    // }




    // @PostMapping("/cadEditora")
    // public Editora cadEditora(@RequestBody Editora editora)
    // {
    //     Editora editor = new Editora();
    //     String fil = editora.getNome_editora().toUpperCase();
    //     List<Editora> edit = editoraRepository.findAllWithFilter(fil);
    //     if(edit.isEmpty())
    //        return this.editoraRepository.save(editora);
    //    else 
    //        return editor;
    // }


    
}
