package br.com.agendatarefas.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class tarefas {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    @NotEmpty
    private String nomeTarefa;

    @ManyToOne
    @JoinColumn(name = "id_Lista_Tarefas")
    private ListaTarefas listatarefas;
}
