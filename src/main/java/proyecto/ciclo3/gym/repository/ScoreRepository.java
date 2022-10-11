package proyecto.ciclo3.gym.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyecto.ciclo3.gym.model.Score;
import proyecto.ciclo3.gym.repository.crud.ScoreRepositoryCrud;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreRepositoryCrud scoreRepositoryCrud;

    public List<Score> ListScore() {

        return (List<Score>) scoreRepositoryCrud.findAll();

    }

    public Optional<Score> idScore(int id) {
        return scoreRepositoryCrud.findById(id);
    }

    public Score guardarScore(Score sc) {

        return scoreRepositoryCrud.save(sc);

    }

}
