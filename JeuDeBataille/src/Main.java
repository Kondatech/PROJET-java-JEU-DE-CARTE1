public class Main {
    public static void main(String[] args) {
        // Crée deux joueurs
        Joueur joueur1 = new Joueur("Alice");
        Joueur joueur2 = new Joueur("Bob");

        // Crée et démarre le jeu
        JeuDeBataille jeu = new JeuDeBataille(joueur1, joueur2);

        // Simule plusieurs tours
        for (int i = 0; i < 10; i++) { // Exemple : 10 tours
            jeu.jouerUnTour();
        }
    }
}
