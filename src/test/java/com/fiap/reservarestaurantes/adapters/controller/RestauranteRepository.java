package com.fiap.reservarestaurantes.adapters.controller;

import com.fiap.reservarestaurantes.entity.Restaurante;

import java.util.List;

public interface RestauranteRepository {
    void save(Restaurante restaurante);

    List<Restaurante> findAll();
}
