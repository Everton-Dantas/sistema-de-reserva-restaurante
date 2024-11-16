
package com.fiap.reservarestaurantes.repository;

import com.fiap.reservarestaurantes.entities.Reserva;
import com.fiap.reservarestaurantes.entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByRestaurante(Restaurante restaurante);
}
