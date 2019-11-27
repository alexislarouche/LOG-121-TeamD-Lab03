package fenetre;

import command.Command;
import command.LoadImage;
import mvc.Model;
import mvc.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetrePerspective extends JFrame implements Observer {
    private PanneauPrincipal panneau;
    private Model model;
    private static final Dimension DIMENSION = new Dimension(500, 400);

    public FenetrePerspective(String title, int x, int y, Model model) {
        setTitle(title);
        this.model = model;
        createFenetre(x, y);
    }

    private final void createFenetre(int x, int y) {
        panneau = new PanneauPrincipal();

        Command loadImage = new LoadImage(model);
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

    @Override
    public void update() {
        panneau.setBackgroundImage(model.getImage());
        repaint();
    }
}
