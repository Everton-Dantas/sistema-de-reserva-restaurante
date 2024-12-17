package com.fiap.reservarestaurantes.adapters.repository;

import com.fiap.reservarestaurantes.entity.Restaurante;
import com.fiap.reservarestaurantes.repository.RestauranteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RestauranteRepositoryTest {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Test
    void deveSalvarERetornarRestaurante() {
        // Criando um objeto restaurante
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Teste");
        restaurante.setEndereco("Rua Teste");
        restaurante.setTelefone("12345-6789");
        restaurante.setCapacidade(50);
        restaurante.setCategoria("Italiana");

        // Salvando no repositório
        Restaurante saved = restauranteRepository.save(restaurante);

        // Validando o retorno
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getNome()).isEqualTo("Restaurante Teste");
        assertThat(saved.getEndereco()).isEqualTo("Rua Teste");
        assertThat(saved.getTelefone()).isEqualTo("12345-6789");
        assertThat(saved.getCapacidade()).isEqualTo(50);
        assertThat(saved.getCategoria()).isEqualTo("Italiana");
    }
}
