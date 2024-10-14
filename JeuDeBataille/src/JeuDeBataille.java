import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class JeuDeBataille {
    private Joueur joueur1;
    private Joueur joueur2;
    private List<Carte> paquet;

    public JeuDeBataille(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.paquet = creerPaquet();
        distribuerCartes();
    }

    private List<Carte> creerPaquet() {
        String[] couleurs = {"Cœur", "Pique", "Carreau", "Trèfle"};
        List<Carte> paquet = new LinkedList<>();
        for (String couleur : couleurs) {
            for (int valeur = 1; valeur <= 13; valeur++) {
                paquet.add(new Carte(valeur, couleur));
            }
        }
        Collections.shuffle(paquet); // Mélange du paquet
        return paquet;
    }

    private void distribuerCartes() {
        for (int i = 0; i < paquet.size(); i++) {
            if (i % 2 == 0) {
                joueur1.ajouterCarte(paquet.get(i));
            } else {
                joueur2.ajouterCarte(paquet.get(i));
            }
        }
    }

    public void jouerUnTour() {
        Carte carte1 = joueur1.jouerCarte();
        Carte carte2 = joueur2.jouerCarte();

        if (carte1 != null && carte2 != null) {
            System.out.println(joueur1.getNom() + " joue " + carte1);
            System.out.println(joueur2.getNom() + " joue " + carte2);

            if (carte1.getValeur() > carte2.getValeur()) {
                System.out.println(joueur1.getNom() + " gagne ce tour.");
            } else if (carte1.getValeur() < carte2.getValeur()) {
                System.out.println(joueur2.getNom() + " gagne ce tour.");
            } else {
                System.out.println("Égalité !");
            }
        } else {
            System.out.println("Une des piles est vide !");
        }
    }
}
