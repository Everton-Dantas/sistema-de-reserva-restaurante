
package com.fiap.reservarestaurantes.usecases;

import com.fiap.reservarestaurantes.repository.RestauranteRepository;
import com.fiap.reservarestaurantes.entity.Restaurante;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Optional<Restaurante> buscarPorId(Long id) {
        return restauranteRepository.findById(id);
    }
}
