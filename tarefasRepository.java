package br.com.agendatarefas.br.com.agendatarefas.repository;

import br.com.agendatarefas.model.tarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface tarefasRepository extends JpaRepository<tarefas, Integer> {


    @Query("select s from tarefas s join s.listatarefas c " +
            "where upper(c.nome) like upper( :nome) ")
    List<tarefas> findByNomeTarefa(@Param("nome")String nome);


}
