
package com.fiap.reservarestaurantes.repository;

import com.fiap.reservarestaurantes.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    @Query("SELECT r FROM Restaurante r WHERE " +
           "(:nome IS NULL OR r.nome LIKE %:nome%) AND " +
           "(:localizacao IS NULL OR r.localizacao LIKE %:localizacao%) AND " +
           "(:tipoCozinha IS NULL OR r.tipoCozinha LIKE %:tipoCozinha%)")
    List<Restaurante> findByNomeContainingAndLocalizacaoContainingAndTipoCozinhaContaining(
            @Param("nome") String nome,
            @Param("localizacao") String localizacao,
            @Param("tipoCozinha") String tipoCozinha);
}
