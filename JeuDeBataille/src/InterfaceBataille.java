import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceBataille extends JFrame {
    private JeuDeBataille jeu;
    private JTextArea affichageJeu;
    private JButton boutonDemarrer;

    public InterfaceBataille() {
        // Configuration de la fenêtre
        setTitle("Jeu de Bataille");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Zone de texte pour afficher les tours
        affichageJeu = new JTextArea();
        affichageJeu.setEditable(false);
        add(new JScrollPane(affichageJeu), BorderLayout.CENTER);

        // Bouton "Démarrer"
        boutonDemarrer = new JButton("Démarrer le jeu");
        boutonDemarrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                demarrerJeu();
            }
        });
        add(boutonDemarrer, BorderLayout.SOUTH);
    }

    // Méthode pour démarrer le jeu
    private void demarrerJeu() {
        Joueur joueur1 = new Joueur("Alice");
        Joueur joueur2 = new Joueur("Bob");
        jeu = new JeuDeBataille(joueur1, joueur2);

        for (int i = 0; i < 10; i++) { // Exemple de 10 tours
            jeu.jouerUnTour();
            affichageJeu.append("Tour " + (i + 1) + " :\n");
            Carte carte1 = joueur1.jouerCarte();
            Carte carte2 = joueur2.jouerCarte();
            if (carte1 != null && carte2 != null) {
                affichageJeu.append(joueur1.getNom() + " joue " + carte1 + "\n");
                affichageJeu.append(joueur2.getNom() + " joue " + carte2 + "\n");

                if (carte1.getValeur() > carte2.getValeur()) {
                    affichageJeu.append(joueur1.getNom() + " gagne ce tour.\n");
                } else if (carte1.getValeur() < carte2.getValeur()) {
                    affichageJeu.append(joueur2.getNom() + " gagne ce tour.\n");
                } else {
                    affichageJeu.append("Égalité !\n");
                }
            } else {
                affichageJeu.append("Le jeu est terminé.\n");
                break;
            }
        }
    }

    public static void main(String[] args) {
        // Créer et afficher l'interface graphique
        InterfaceBataille interfaceJeu = new InterfaceBataille();
        interfaceJeu.setVisible(true);
    }
}
