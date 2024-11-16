
package com.fiap.reservarestaurantes.adapters.repository;

import com.fiap.reservarestaurantes.entities.Restaurante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RestauranteRepositoryTest {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Test
    void deveSalvarERetornarRestaurante() {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Teste");
        restaurante.setCapacidade(50);
        restauranteRepository.save(restaurante);

        List<Restaurante> restaurantes = restauranteRepository.findAll();
        assertEquals(1, restaurantes.size());
        assertEquals("Restaurante Teste", restaurantes.get(0).getNome());
    }
}
