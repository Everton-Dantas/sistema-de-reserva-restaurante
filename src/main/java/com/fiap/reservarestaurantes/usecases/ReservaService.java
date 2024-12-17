
package com.fiap.reservarestaurantes.usecases;

import com.fiap.reservarestaurantes.entity.Reserva;
import com.fiap.reservarestaurantes.entity.Restaurante;
import com.fiap.reservarestaurantes.entity.StatusReserva;
import com.fiap.reservarestaurantes.repository.ReservaRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva criarReserva(Reserva reserva, Restaurante restaurante) {
        reserva.setRestaurante(restaurante);
        return reservaRepository.save(reserva);
    }

    public List<Reserva> listarReservasPorRestaurante(Restaurante restaurante) {
        return reservaRepository.findByRestaurante(restaurante);
    }

    public Reserva atualizarStatusReserva(Reserva reserva, StatusReserva status) {
        reserva.setStatus(status);
        return reservaRepository.save(reserva);
    }

    public Optional<Reserva> buscarPorId(Long reservaId) {
        return Optional.empty();
    }
}
