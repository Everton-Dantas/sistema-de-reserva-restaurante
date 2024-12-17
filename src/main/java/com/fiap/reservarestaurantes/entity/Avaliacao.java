package com.fiap.reservarestaurantes.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // Lombok gera getters e setters automaticamente
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int nota;
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "restaurante_id") // Define a chave estrangeira
    private Restaurante restaurante; // Atributo de relacionamento
}

