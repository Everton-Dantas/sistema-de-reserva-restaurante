package com.fiap.reservarestaurantes.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "avaliacoes") // Nome da tabela no banco de dados
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comentario;
    private Integer nota;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante; // Associação com Restaurante
}



