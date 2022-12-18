package player;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Entity
public class Player {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String poste;
    private int fg3pts;

    public Player(int id,String nom, String prenom, String poste, int fg3pts){
        this.id=id;
        this.nom=nom;
        this.prenom =prenom;
        this.poste=poste;
        this.fg3pts=fg3pts;
    }

    public Player(String nom, String prenom, String poste, int fg3pts){
        this.nom=nom;
        this.prenom =prenom;
        this.poste=poste;
        this.fg3pts=fg3pts;
    }


    protected Player() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getFg3pts() {
        return fg3pts;
    }

    public void setFg3pts(int fg3pts) {
        this.fg3pts = fg3pts;
    }

    @Override
    public String toString(){
        return this.nom + " - " + this.prenom + " - " + this.poste + " - " + this.fg3pts;
    }


}
