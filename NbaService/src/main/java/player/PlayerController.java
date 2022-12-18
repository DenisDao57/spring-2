package player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PlayerController {

    @Autowired
    private PlayerRepository dao;

    @ResponseBody
    @GetMapping(value="/players",produces = "application/json")
    public Iterable<Player> getAllPlayers(){
        return dao.findAll();
    }

    @ResponseBody
    @GetMapping(value="/players/poste/{poste}",produces = "application/json")
    public ArrayList<Player> getPlayersByPost(@PathVariable String poste){
        return dao.findByPoste(poste);
    }



    @ResponseBody
    @DeleteMapping(value="/players/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> deletePlayer(@PathVariable int id){
        dao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
