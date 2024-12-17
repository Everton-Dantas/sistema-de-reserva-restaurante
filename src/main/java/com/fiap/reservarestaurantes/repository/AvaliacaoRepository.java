
package com.fiap.reservarestaurantes.repository;

import com.fiap.reservarestaurantes.entity.Avaliacao;
import com.fiap.reservarestaurantes.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findByRestaurante(Restaurante restaurante);
}
