
package com.fiap.reservarestaurantes.controller;

import com.fiap.reservarestaurantes.entity.Restaurante;
import com.fiap.reservarestaurantes.repository.RestauranteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
@Data
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @PostMapping
    public ResponseEntity<Restaurante> cadastrarRestaurante(@RequestBody Restaurante restaurante) {
        Restaurante novoRestaurante = restauranteRepository.save(restaurante);
        return ResponseEntity.ok(novoRestaurante);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Restaurante>> buscarRestaurantes(@RequestParam(required = false) String nome,
                                                                @RequestParam(required = false) String localizacao,
                                                                @RequestParam(required = false) String tipoCozinha) {
        List<Restaurante> restaurantes = restauranteRepository.findByNomeContainingAndLocalizacaoContainingAndTipoCozinhaContaining(
                nome == null ? "" : nome, 
                localizacao == null ? "" : localizacao, 
                tipoCozinha == null ? "" : tipoCozinha
        );
        return ResponseEntity.ok(restaurantes);
    }
}
