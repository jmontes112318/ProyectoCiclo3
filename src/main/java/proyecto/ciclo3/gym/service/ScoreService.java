package proyecto.ciclo3.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import proyecto.ciclo3.gym.model.Score;
import proyecto.ciclo3.gym.repository.ScoreRepository;

@Service
public class ScoreService {

    private ScoreRepository scoreRepository;

    public List<Score> listarScore() {

        return scoreRepository.ListScore();

    }

    public Optional<Score> scoreId(int id) {

        return scoreRepository.idScore(id);

    }

    public Score scoreGuardar(Score sc) {
        if (sc.getIdScore() == null) {

            return scoreRepository.guardarScore(sc);

        } else {

            Optional<Score> scr = scoreRepository.idScore(sc.getIdScore());

            if (scr.isEmpty()) {

                return scoreRepository.guardarScore(sc);

            } else {

                return sc;

            }

        }

    }

}
