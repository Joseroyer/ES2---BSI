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
import es2.projeto.librarytree.repositories.GeneroLivroRepository;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpRange;
import org.springframework.web.bind.annotation.*;
import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/apis")
public class GeneroControl {
    @Autowired
    GeneroLivroRepository generoLivroRepository;

    @GetMapping("/genero")
    public List<GeneroLivro> getAllGenero(){
        return this.generoLivroRepository.findAll();
    }


    @GetMapping("/listar-todos-generos")
    public ResponseEntity <Object> buscarTodosGeneros()
    {
        List <GeneroLivro> gens = generoLivroRepository.findAll();
        return new ResponseEntity<>(gens,HttpStatus.CREATED);
    }

    // @GetMapping("/genero/{id}")
    // public ResponseEntity<GeneroLivro> getGeneroById(@PathVariable(value="id") GeneroLivro generoId) throws ResolutionException
    // {
    //         GeneroLivro genero = generoLivroRepository.findById(generoId.getIdgenero())
    //             .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada para o código "+ generoId));
    //     return ResponseEntity.ok().body(genero);
    // }

    // //Insert Categoria
    // @PostMapping("/genero")
    // public GeneroLivro createGenero(@RequestBody GeneroLivro genero) {return this.generoLivroRepository.save(genero);}


    // @PutMapping("/genero/{id}")
    // public ResponseEntity<GeneroLivro> updateCategoria(@PathVariable (value="idgenero") Long generoId,
    //                                            @RequestBody GeneroLivro generoDetails) throws ResourceNotFoundException{
    //     GeneroLivro genero = generoLivroRepository.findById(generoId)
    //             .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada para o código " + generoId));
    //     //PARAMETROS PARA PASSAR

    //     genero.setTpgenero(generoDetails.getTpgenero());

    //     //Retorno
    //     final GeneroLivro updatedGenero = generoLivroRepository.save(genero);
    //     return ResponseEntity.ok(updatedGenero);
    // }

    // @DeleteMapping("/genero/{id}")
    // public Map<String, Boolean> deleteGenero(@PathVariable (value = "idgenero") Long generoId) throws ResourceNotFoundException{
    //     GeneroLivro genero = generoLivroRepository.findById(generoId)
    //             .orElseThrow(() -> new ResourceNotFoundException("Genero nao encontrado para o codigo " + generoId));

    //     this.generoLivroRepository.delete(genero);
    //     Map<String, Boolean> response = new HashMap<>();
    //     response.put("deleted", Boolean.TRUE);
    //     return response;
    // }
    
}
