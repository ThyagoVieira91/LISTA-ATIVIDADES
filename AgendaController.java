package br.com.agendatarefas.controller;

import br.com.agendatarefas.model.ListaTarefas;
import br.com.agendatarefas.br.com.agendatarefas.repository.ListaTarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/gerenciadordetarefas")
@CrossOrigin("http://localhost:4200")
public class AgendaController {

private final ListaTarefasRepository listr;


    @Autowired
    public AgendaController(ListaTarefasRepository listr) {

            this.listr = listr;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ListaTarefas salvarLista(@RequestBody @Valid ListaTarefas listatarefas){

        return listr.save(listatarefas);
    }


    @GetMapping("/{id}")
    public ListaTarefas procurar(@PathVariable Integer id){
        return listr.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<ListaTarefas> obterTodos(){

        return listr.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        listr.findById(id).map(listaTarefas -> { listr.delete(ListaTarefas.builder().build()); return Void.TYPE; }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody ListaTarefas listatarefasatualizada){
        listr.findById(id).map(listaTarefas -> {listaTarefas.setNome(listaTarefas.getNome());
            return listr.save(listatarefasatualizada);}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
