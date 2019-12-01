package fenetre;

import command.Command;
import command.LoadImage;
import mvc.BackgroundImage;
import mvc.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
Fenêtre principale de l'application
 */
public class FenetrePrincipale extends JFrame implements Observer{

    private PanneauPrincipal panneau;
    private BackgroundImage bgImage;
    private static final String TITRE_FENETRE = "Laboratoire 3 : LOG121";
    private static final Dimension DIMENSION = new Dimension(500, 400);

    /**
     * Constructeur de la fenêtre principale de l'application
     */
    public FenetrePrincipale(int x, int y, BackgroundImage bgImage){
        setTitle(TITRE_FENETRE);
        this.bgImage = bgImage;
        createFenetre(x, y);
    }

    private final void createFenetre(int x, int y) {
        panneau = new PanneauPrincipal();

        Command loadImage = new LoadImage(bgImage);
        BarOutils barreOutils = new BarOutils(loadImage);

        setLayout(new BorderLayout());

        add(panneau, BorderLayout.CENTER);
        add(barreOutils, BorderLayout.NORTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(DIMENSION);
        // Rendre la fenêtre visible
        setVisible(true);

        setLocation(x,y);

        // Emp�cher la redimension de la fen�tre
        setResizable(false);
    }

    @Override
    public void update() {
        if (panneau.getBackgroundImage() == null) {
            panneau.setBackgroundImage(bgImage.getImage());
            repaint();
        }
    }
}
