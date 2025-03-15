package com.fiap.reservarestaurantes.adapters.controller;

import com.fiap.reservarestaurantes.entities.Restaurante;
import com.fiap.reservarestaurantes.repository.RestauranteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RestauranteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Test
    void deveRetornarRestaurantesCadastrados() throws Exception {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Teste");
        restaurante.setCapacidade(50);
        restauranteRepository.save(restaurante);

        mockMvc.perform(get("/restaurantes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Novo Restaurante"));
    }

    @Test
    void deveCadastrarNovoRestaurante() throws Exception {
        String novoRestaurante = "{"
                + "\"nome\": \"Novo Restaurante\","
                + "\"localizacao\": \"Rua Teste\","
                + "\"tipoCozinha\": \"Italiana\","
                + "\"horarioFuncionamento\": \"10:00-22:00\","
                + "\"capacidade\": 30"
                + "}";

        mockMvc.perform(post("/restaurantes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(novoRestaurante))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Novo Restaurante"));
    }
}
