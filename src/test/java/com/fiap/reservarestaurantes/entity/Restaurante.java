package com.fiap.reservarestaurantes.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "restaurantes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private int capacidade;
    private String categoria;
    private String localizacao;
    private String tipoCozinha;

}