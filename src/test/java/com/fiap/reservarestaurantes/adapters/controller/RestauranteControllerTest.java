package com.fiap.reservarestaurantes.adapters.controller;

import com.fiap.reservarestaurantes.entities.Restaurante;
import com.fiap.reservarestaurantes.repository.RestauranteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.annotation.DirtiesContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")  // Garante que o H2 será usado
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) // Recria o contexto após cada teste
class RestauranteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @BeforeEach
    void setup() {
        restauranteRepository.deleteAll(); // Limpa os dados antes de cada teste
    }

    @Test
    void deveRetornarRestaurantesCadastrados() throws Exception {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Teste");
        restaurante.setCapacidade(50);
        restaurante.setLocalizacao("Rua A");
        restaurante.setTipoCozinha("Italiana");

        restauranteRepository.saveAndFlush(restaurante); // Garante que os dados sejam persistidos

        mockMvc.perform(get("/restaurantes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Restaurante Teste"));
    }

    @Test
    void deveCadastrarNovoRestaurante() throws Exception {
        String novoRestaurante = "{" +
                "\"nome\": \"Novo Restaurante\"," +
                "\"localizacao\": \"Rua Teste\"," +
                "\"tipoCozinha\": \"Italiana\"," +
                "\"capacidade\": 30" +
                "}";

        mockMvc.perform(post("/restaurantes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(novoRestaurante))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Novo Restaurante"));
    }
}