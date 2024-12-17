
package com.fiap.reservarestaurantes.controller;

import com.fiap.reservarestaurantes.entity.Reserva;
import com.fiap.reservarestaurantes.entity.StatusReserva;
import com.fiap.reservarestaurantes.entity.Restaurante;
import com.fiap.reservarestaurantes.usecases.ReservaService;
import com.fiap.reservarestaurantes.usecases.RestauranteService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<?> criarReserva(@RequestBody Reserva reserva) {
        val restauranteOpt = restauranteService.buscarPorId(reserva.getRestaurante().getId());
        if (!restauranteOpt.isPresent()) {  // Substituindo isEmpty() por !isPresent()
            return ResponseEntity.badRequest().body("Restaurante não encontrado");
        }
        Reserva novaReserva = reservaService.criarReserva(reserva, restauranteOpt.get());
        return ResponseEntity.ok(novaReserva);
    }

    @GetMapping("/restaurante/{restauranteId}")
    public ResponseEntity<List<Reserva>> listarReservasPorRestaurante(@PathVariable Long restauranteId) {
        Optional<Restaurante> restauranteOpt = restauranteService.buscarPorId(restauranteId);
        if (!restauranteOpt.isPresent()) {  // Substituindo isEmpty() por !isPresent()
            return ResponseEntity.notFound().build();
        }
        List<Reserva> reservas = reservaService.listarReservasPorRestaurante(restauranteOpt.get());
        return ResponseEntity.ok(reservas);
    }

    @PutMapping("/{reservaId}/status")
    public ResponseEntity<?> atualizarStatusReserva(@PathVariable Long reservaId, @RequestParam StatusReserva status) {
        Optional<Reserva> reservaOpt = reservaService.buscarPorId(reservaId);
        if (!reservaOpt.isPresent()) {  // Substituindo isEmpty() por !isPresent()
            return ResponseEntity.notFound().build();
        }
        Reserva reservaAtualizada = reservaService.atualizarStatusReserva(reservaOpt.get(), status);
        return ResponseEntity.ok(reservaAtualizada);
    }
}
