
package com.fiap.reservarestaurantes.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String localizacao;

    private String tipoCozinha;

    private int capacidade;

    public Restaurante() {}

    public Restaurante(Long id, String nome, String localizacao, String tipoCozinha, int capacidade) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.tipoCozinha = tipoCozinha;
        this.capacidade = capacidade;
    }
}
