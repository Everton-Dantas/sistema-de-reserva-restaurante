
package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class LoadTestSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8080") // URL base da API
    .acceptHeader("application/json")
    .contentTypeHeader("application/json")

  val scn = scenario("Carga de API - Cadastro e Busca")
    .exec(
      http("Cadastro de Restaurante")
        .post("/restaurantes")
        .body(StringBody("""
          {
            "nome": "Restaurante Teste",
            "localizacao": "Rua Exemplo",
            "tipoCozinha": "Italiana",
            "horarioFuncionamento": "10:00-22:00",
            "capacidade": 50
          }
        """)).asJson
        .check(status.is(200))
    )
    .pause(1 second)
    .exec(
      http("Busca de Restaurantes")
        .get("/restaurantes")
        .check(status.is(200))
    )

  setUp(
    scn.inject(
      rampUsers(100).during(30.seconds), // 100 usuários em 30 segundos
      constantUsersPerSec(50).during(1.minute) // 50 usuários por segundo por 1 minuto
    )
  ).protocols(httpProtocol)
}
