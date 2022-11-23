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
        List <Suspensao> titulos = susRepository.findAllWithFilter(filtrar);
        return new ResponseEntity<>(titulos,HttpStatus.OK);
    }


    @RequestMapping("/remover-suspensao")
    public Suspensao remsuspensao(@RequestParam(value="id")Suspensao  id)
    {
        Optional<Suspensao > suspensao = susRepository.findById(id.getIdsus());
        id.setIdsus(suspensao.get().getIdsus());//id da suspensao
        id.setEmpsus(suspensao.get().getEmpsus());//empréstimo suspenso 
        //acredito que precise passar a chave estrangeira também..
        id.setIdsus(0);
        return this.susRepository.save(id);
    }

    @RequestMapping("/editar-suspensao")
    public Suspensao edisuspensao(@RequestParam(value="EditarSuspensao") Suspensao EditarSuspensao, @RequestParam(value="Nome") String Nome){
        {
            Optional<Suspensao> Sus = susRepository.findById(EditarSuspensao.getIdsus());
            EditarSuspensao.setIdsus(Sus.get().getIdsus());
            EditarSuspensao.setEmpsus(Nome);
            EditarSuspensao.setSuspstt(1);
            return this.susRepository.save(EditarSuspensao);

        }
    }

    @PostMapping("/Cadastrar-Suspensao")
        public ResponseEntity<Object> AtribuirSuspensao(@RequestBody Suspensao sus){
            sus.setSuspstt(1);
            System.out.println(sus);
            return new ResponseEntity<>(susRepository.save(sus),HttpStatus.OK);
        }
}
