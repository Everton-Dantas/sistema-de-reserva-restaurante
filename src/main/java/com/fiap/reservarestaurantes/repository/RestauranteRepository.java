
package com.fiap.reservarestaurantes.repository;

import com.fiap.reservarestaurantes.entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fiap.reservarestaurantes.repository.RestauranteRepository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    List<Restaurante> findByNomeContainingAndLocalizacaoContainingAndTipoCozinhaContaining(String nome, String localizacao, String tipoCozinha);
}
