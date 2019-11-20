package fenetre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
Fenêtre principale de l'application
 */
public class FenetrePrincipale extends JFrame {

    private static final String TITRE_FENETRE = "Laboratoire 3 : LOG121";
    private static final Dimension DIMENSION = new Dimension(900, 700);

    /**
     * Constructeuer de la fenêtre principale de l'application
     */
    public FenetrePrincipale(){
        PanneauPrincipal panneau = new PanneauPrincipal();
        BarOutils barreOutils = new BarOutils();
        setLayout(new BorderLayout());


        add(panneau,BorderLayout.CENTER);
        add(barreOutils, BorderLayout.NORTH);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(TITRE_FENETRE);
        setSize(DIMENSION);
        // Rendre la fenêtre visible
        setVisible(true);
        // Mettre la fenêtre au centre de l'écran
        setLocationRelativeTo(null);
        // Emp�cher la redimension de la fen�tre
        setResizable(false);


        this.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                //TODO : Set MousePressedEvents (if any)
            }


            public void mouseReleased(MouseEvent e) {
                //TODO : Set MouseReleasedEvents (if any)
            }

        });

        this.addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                //TODO : Set MouseDraggedEvents (if any)
            }
        });

        this.addMouseWheelListener(new MouseWheelListener() {

            public void mouseWheelMoved(MouseWheelEvent e) {
                //TODO : Set MouseWheelMovedEvents (if any)
            }

        });

        this.addKeyListener(new KeyListener() {


            @Override
            public void keyTyped(KeyEvent e) {
                //TODO : Set KeyTypedEvents (if any)
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //TODO : Set KeyPressedEvents (if any)
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //TODO : Set KeyReleasedEvents (if any)
            }


        });

    }
}
