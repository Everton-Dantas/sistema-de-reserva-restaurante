
package com.fiap.reservarestaurantes.usecases;

import com.fiap.reservarestaurantes.entities.Restaurante;
import com.fiap.reservarestaurantes.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante cadastrarRestaurante(Restaurante restaurante) {
        if (restaurante.getNome() == null || restaurante.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do restaurante é obrigatório.");
        }
        if (restaurante.getCapacidade() <= 0) {
            throw new IllegalArgumentException("Capacidade do restaurante deve ser maior que zero.");
        }
        return restauranteRepository.save(restaurante);
    }

    public List<Restaurante> buscarRestaurantes(String nome, String localizacao, String tipoCozinha) {
        return restauranteRepository.findByNomeContainingAndLocalizacaoContainingAndTipoCozinhaContaining(
                nome == null ? "" : nome,
                localizacao == null ? "" : localizacao,
                tipoCozinha == null ? "" : tipoCozinha
        );
    }

    public Optional<Restaurante> buscarPorId(Long id) {
        return restauranteRepository.findById(id);
    }
}
