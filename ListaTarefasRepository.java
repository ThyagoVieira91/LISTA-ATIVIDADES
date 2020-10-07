package br.com.agendatarefas.br.com.agendatarefas.repository;


import br.com.agendatarefas.model.ListaTarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaTarefasRepository extends JpaRepository<ListaTarefas, Integer> {
}
