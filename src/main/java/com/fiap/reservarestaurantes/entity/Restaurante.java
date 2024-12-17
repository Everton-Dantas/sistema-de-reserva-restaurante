package com.fiap.reservarestaurantes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurantes")
@Data // Gera getters, setters, toString, equals e hashCode
@NoArgsConstructor // Construtor vazio necessário para JPA
@AllArgsConstructor // Construtor com todos os parâmetros
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
