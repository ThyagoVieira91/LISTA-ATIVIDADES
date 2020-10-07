package br.com.agendatarefas.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class ListaTarefas{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(nullable = false)
@NotEmpty
private String nome;

}
