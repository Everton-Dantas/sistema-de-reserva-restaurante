package com.fiap.reservarestaurantes.controller;

import com.fiap.reservarestaurantes.entities.Avaliacao;
import com.fiap.reservarestaurantes.entities.Restaurante;
import com.fiap.reservarestaurantes.usecases.AvaliacaoService;
import com.fiap.reservarestaurantes.usecases.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<?> criarAvaliacao(@RequestBody Avaliacao avaliacao) {
        Optional<Restaurante> restauranteOpt = restauranteService.buscarPorId(avaliacao.getRestaurante().getId());
        if (!restauranteOpt.isPresent()) {  // Substituindo isEmpty() por !isPresent()
            return ResponseEntity.badRequest().body("Restaurante não encontrado");
        }
        Avaliacao novaAvaliacao = avaliacaoService.criarAvaliacao(avaliacao, restauranteOpt.get());
        return ResponseEntity.ok(novaAvaliacao);
    }

    @GetMapping("/restaurante/{restauranteId}")
    public ResponseEntity<List<Avaliacao>> listarAvaliacoesPorRestaurante(@PathVariable Long restauranteId) {
        Optional<Restaurante> restauranteOpt = restauranteService.buscarPorId(restauranteId);
        if (!restauranteOpt.isPresent()) {  // Substituindo isEmpty() por !isPresent()
            return ResponseEntity.notFound().build();
        }
        List<Avaliacao> avaliacoes = avaliacaoService.listarAvaliacoesPorRestaurante(restauranteOpt.get());
        return ResponseEntity.ok(avaliacoes);
    }
}
