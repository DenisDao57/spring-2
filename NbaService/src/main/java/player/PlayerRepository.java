package player;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


public interface PlayerRepository extends CrudRepository<Player, Integer> {

    ArrayList<Player> findByPoste(String poste);
    Player findById(int id);
    void deleteById(int id);

}
