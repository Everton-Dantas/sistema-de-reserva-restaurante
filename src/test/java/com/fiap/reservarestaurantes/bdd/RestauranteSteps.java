package com.fiap.reservarestaurantes.bdd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.reservarestaurantes.entities.Restaurante;
import com.fiap.reservarestaurantes.repository.RestauranteRepository;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
public class RestauranteSteps {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RestauranteRepository restauranteRepository;

    private Restaurante restaurante;
    private MvcResult result;

    @Given("existe um restaurante com os seguintes dados:")
    public void existeUmRestauranteComOsSeguintesDados(DataTable dataTable) {
        Map<String, String> dados = dataTable.asMaps().get(0);
        restaurante = new Restaurante();
        restaurante.setNome(dados.get("nome"));
        restaurante.setLocalizacao(dados.get("localizacao"));
        restaurante.setTipoCozinha(dados.get("tipoCozinha"));
        restaurante.setHorarioFuncionamento(dados.get("horarioFuncionamento"));
        restaurante.setCapacidade(Integer.parseInt(dados.get("capacidade")));
    }

    @When("eu envio uma requisição para cadastrar este restaurante")
    public void euEnvioUmaRequisicaoParaCadastrarEsteRestaurante() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(restaurante);

        result = mockMvc.perform(MockMvcRequestBuilders.post("/restaurantes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();
    }

    @Then("o restaurante é salvo no sistema com sucesso")
    public void oRestauranteESalvoNoSistemaComSucesso() {
        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertTrue(restauranteRepository.findByNome(restaurante.getNome()).isPresent());
    }

    @Then("o sistema retorna um erro indicando que o nome é obrigatório")
    public void oSistemaRetornaUmErroIndicandoQueONomeEObrigatorio() {
        Assertions.assertEquals(400, result.getResponse().getStatus());
    }
}
