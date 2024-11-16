
package com.fiap.reservarestaurantes.controller;

import com.fiap.reservarestaurantes.entities.Restaurante;
import com.fiap.reservarestaurantes.usecases.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<Restaurante> cadastrarRestaurante(@RequestBody Restaurante restaurante) {
        Restaurante novoRestaurante = restauranteService.cadastrarRestaurante(restaurante);
        return ResponseEntity.ok(novoRestaurante);
    }

    @GetMapping
    public ResponseEntity<List<Restaurante>> buscarRestaurantes(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String localizacao,
            @RequestParam(required = false) String tipoCozinha) {
        List<Restaurante> restaurantes = restauranteService.buscarRestaurantes(nome, localizacao, tipoCozinha);
        return ResponseEntity.ok(restaurantes);
    }
}
