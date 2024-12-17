
package com.fiap.reservarestaurantes.repository;

import com.fiap.reservarestaurantes.entity.Reserva;
import com.fiap.reservarestaurantes.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByRestaurante(Restaurante restaurante);
}
