package br.com.agendatarefas.controller;

import br.com.agendatarefas.br.com.agendatarefas.repository.ListaTarefasRepository;
import br.com.agendatarefas.br.com.agendatarefas.repository.tarefasRepository;
import br.com.agendatarefas.controller.dto.tarefasDTO;
import br.com.agendatarefas.model.ListaTarefas;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.com.agendatarefas.model.tarefas;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin("http://localhost:4200")
public class TarefasController {

private final ListaTarefasRepository listatarefasrepository;

private final tarefasRepository tarefasRepository;

public TarefasController(ListaTarefasRepository listatarefasrepository, tarefasRepository tarefasrepository){

    this.tarefasRepository = tarefasrepository;
    this.listatarefasrepository = listatarefasrepository;
}


@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public tarefas  salvar(@RequestBody @Valid tarefasDTO dto){


         Integer idListaTarefas = dto.getIdListaTarefas();


         ListaTarefas listatarefas = listatarefasrepository.findById(idListaTarefas)
                 .orElseThrow( ()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "lista de tarefas inexistente."));

         tarefas tarefas = new tarefas();

         tarefas.setNomeTarefa(dto.getTarefaNome());
         tarefas.setListatarefas(listatarefas);


         return tarefasRepository.save(tarefas);
}

    @GetMapping
    public List<tarefas> buscar(@RequestParam(value = "nome", required = false) String nome){
        return tarefasRepository.findByNomeTarefa("%"+ nome + "%");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        tarefasRepository.findById(id).map(tarefas -> {tarefasRepository.delete(tarefas); return Void.TYPE; }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
