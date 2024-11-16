
package com.fiap.reservarestaurantes.usecases;

import com.fiap.reservarestaurantes.entities.Restaurante;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RestauranteUseCaseTest {

    @Test
    void deveCadastrarRestauranteComSucesso() {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Teste");
        restaurante.setCapacidade(50);

        assertEquals("Restaurante Teste", restaurante.getNome());
        assertEquals(50, restaurante.getCapacidade());
    }

    @Test
    void naoDeveCadastrarRestauranteSemNome() {
        Restaurante restaurante = new Restaurante();
        restaurante.setCapacidade(50);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            if (restaurante.getNome() == null || restaurante.getNome().isEmpty()) {
                throw new IllegalArgumentException("Nome do restaurante é obrigatório.");
            }
        });

        assertEquals("Nome do restaurante é obrigatório.", exception.getMessage());
    }
}
