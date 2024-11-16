
package com.fiap.reservarestaurantes.repository;

import com.fiap.reservarestaurantes.entities.Avaliacao;
import com.fiap.reservarestaurantes.entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findByRestaurante(Restaurante restaurante);
}
