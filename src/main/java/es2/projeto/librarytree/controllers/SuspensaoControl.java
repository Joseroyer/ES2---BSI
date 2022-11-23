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
import es2.projeto.librarytree.models.Suspensao;
import es2.projeto.librarytree.models.Cliente;
import es2.projeto.librarytree.repositories.SuspensaoRepository;
import es2.projeto.librarytree.repositories.ClienteRepository;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpRange;


@RestController
@RequestMapping("/apis")
public class SuspensaoControl {
    @Autowired
    SuspensaoRepository susRepository;

    @GetMapping("/listar-suspensao")//Listar suspensões
    public ResponseEntity <Object> todos(){
       return new ResponseEntity<>(susRepository.findAll(),HttpStatus.OK);
    }
    
    @RequestMapping("/listar-uma-suspensao")//lista só uma suspensão
    public ResponseEntity<Object> buscarFiltro(@RequestParam(value="filtro")String filtro)
    {
        String filtrar = filtro.toUpperCase();
        List <Suspensao> suspensao = susRepository.findAllWithFilter(filtrar);
        return new ResponseEntity<>(suspensao,HttpStatus.OK);
    }


    @RequestMapping("/remover-suspensao")
    public Suspensao remsuspensao(@RequestParam(value="id")Suspensao  id)
    {
        Optional<Suspensao > susp = susRepository.findById(id.getIdsus());

        id.setIdsus(susp.get().getIdsus());//id da suspensao
        id.setEmpsus(susp.get().getEmpsus());//empréstimo suspenso 
        id.setIdsus(0);
        System.out.println(id);
        return this.susRepository.save(id);
    }

    @RequestMapping("/editar-suspensao")
    public Suspensao edisuspensao(@RequestParam(value="Identificador") Suspensao Identificador, @RequestParam(value="Nome") String Nome){
        {

        //     Identificador.getId_livro());
        //   Identificador.setId_livro(Tit.get().getId_livro());

            Optional<Suspensao> Sus = susRepository.findById(Identificador.getIdsus());
            Identificador.setIdsus(Sus.get().getIdsus());
            Identificador.setEmpsus(Nome);
            Identificador.setSuspstt(1);
            return this.susRepository.save(Identificador);

        }
    }

    @PostMapping("/CadastrarSuspensao")
        public ResponseEntity<Object> AtribuirSuspensao(@RequestBody Suspensao Susp){
            Susp.setSuspstt(1);
            System.out.println(Susp);
            return new ResponseEntity<>(susRepository.save(Susp),HttpStatus.OK);
        }

        // @PostMapping("/CadastrarNovosTitulos")
        // public ResponseEntity<Object> CadastrarNovoTitulo(@RequestBody GerenTitulos livro){
        //   // GeneroLivro gen = new GeneroLivro(Long.parseLong("1"),"Animais");
        //   livro.setLivrostt(1);
        //   System.out.println(livro);
        //   return new ResponseEntity<>(gerenTitulosRepository.save(livro),HttpStatus.OK);
        // }


}
