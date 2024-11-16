
package com.fiap.reservarestaurantes.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    private int numeroPessoas;

    @Enumerated(EnumType.STRING)
    private StatusReserva status;

    @ManyToOne
    private Restaurante restaurante;

    public Reserva() {}

    public Reserva(Long id, LocalDateTime dataHora, int numeroPessoas, StatusReserva status, Restaurante restaurante) {
        this.id = id;
        this.dataHora = dataHora;
        this.numeroPessoas = numeroPessoas;
        this.status = status;
        this.restaurante = restaurante;
    }
}
