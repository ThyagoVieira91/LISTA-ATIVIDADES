package br.com.agendatarefas.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class tarefasDTO {

    @NotEmpty
    private String tarefaNome;

    private Integer id;

    private Integer idListaTarefas;
}
