
package com.fiap.reservarestaurantes.usecases;

import com.fiap.reservarestaurantes.entities.Avaliacao;
import com.fiap.reservarestaurantes.entities.Restaurante;
import com.fiap.reservarestaurantes.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Avaliacao criarAvaliacao(Avaliacao avaliacao, Restaurante restaurante) {
        if (avaliacao.getNota() < 1 || avaliacao.getNota() > 5) {
            throw new IllegalArgumentException("Nota deve estar entre 1 e 5.");
        }
        if (avaliacao.getComentario() == null || avaliacao.getComentario().isEmpty()) {
            throw new IllegalArgumentException("Comentário é obrigatório.");
        }
        avaliacao.setRestaurante(restaurante);
        return avaliacaoRepository.save(avaliacao);
    }

    public List<Avaliacao> listarAvaliacoesPorRestaurante(Restaurante restaurante) {
        return avaliacaoRepository.findByRestaurante(restaurante);
    }
}
