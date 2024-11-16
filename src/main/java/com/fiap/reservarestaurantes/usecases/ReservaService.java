
package com.fiap.reservarestaurantes.usecases;

import com.fiap.reservarestaurantes.entities.Reserva;
import com.fiap.reservarestaurantes.entities.Restaurante;
import com.fiap.reservarestaurantes.entities.StatusReserva;
import com.fiap.reservarestaurantes.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva criarReserva(Reserva reserva, Restaurante restaurante) {
        validarReserva(reserva, restaurante);
        reserva.setRestaurante(restaurante);
        reserva.setStatus(StatusReserva.RESERVADA);
        return reservaRepository.save(reserva);
    }

    private void validarReserva(Reserva reserva, Restaurante restaurante) {
        if (reserva == null) {
            throw new IllegalArgumentException("A reserva não pode ser nula.");
        }
        if (restaurante == null) {
            throw new IllegalArgumentException("O restaurante não pode ser nulo.");
        }
        if (reserva.getDataHora() == null) {
            throw new IllegalArgumentException("A data e hora da reserva são obrigatórias.");
        }
        if (reserva.getNumeroPessoas() <= 0) {
            throw new IllegalArgumentException("O número de pessoas deve ser maior que zero.");
        }
    }

    public List<Reserva> listarReservasPorRestaurante(Restaurante restaurante) {
        return reservaRepository.findByRestaurante(restaurante);
    }

    public Optional<Reserva> buscarPorId(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva atualizarStatusReserva(Reserva reserva, StatusReserva status) {
        if (reserva == null) {
            throw new IllegalArgumentException("Reserva não pode ser nula.");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status não pode ser nulo.");
        }
        reserva.setStatus(status);
        return reservaRepository.save(reserva); // Atualiza e salva no banco
    }
}
