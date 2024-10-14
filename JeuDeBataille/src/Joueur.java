import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private String nom;
    private List<Carte> main;

    public Joueur(String nom) {
        this.nom = nom;
        this.main = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void ajouterCarte(Carte carte) {
        main.add(carte);
    }

    public Carte jouerCarte() {
        if (!main.isEmpty()) {
            return main.remove(0); // Retire et retourne la première carte
        }
        return null; // Si le joueur n'a plus de cartes
    }

    public boolean aDesCartes() {
        return !main.isEmpty();
    }
}
