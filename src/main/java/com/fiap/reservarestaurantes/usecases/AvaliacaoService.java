
package com.fiap.reservarestaurantes.usecases;

import com.fiap.reservarestaurantes.entity.Avaliacao;
import com.fiap.reservarestaurantes.entity.Restaurante;
import com.fiap.reservarestaurantes.repository.AvaliacaoRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Avaliacao criarAvaliacao(Avaliacao avaliacao, Restaurante restaurante) {
        avaliacao.setRestaurante(restaurante);
        return avaliacaoRepository.save(avaliacao);
    }

    public List<Avaliacao> listarAvaliacoesPorRestaurante(Restaurante restaurante) {
        return avaliacaoRepository.findByRestaurante(restaurante);
    }
}
