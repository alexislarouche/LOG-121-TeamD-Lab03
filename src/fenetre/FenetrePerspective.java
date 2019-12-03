package fenetre;

import command.*;
import mvc.BackgroundImage;
import mvc.Observer;
import mvc.Perspective;
import singleton.AppState;
import singleton.Mementos;
import singleton.SingletonGestionnaireCommande;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;

public class FenetrePerspective extends JFrame implements Observer {
    private PanneauPrincipal panneau;
    private Perspective perspective;
    private BackgroundImage bgImage;
    private static final Dimension DIMENSION = new Dimension(500, 400);

    public FenetrePerspective(String title, int x, int y, BackgroundImage bgImage,Perspective perspective) {
        setTitle(title);
        this.perspective = perspective;
        this.bgImage = bgImage;
        createFenetre(x, y);
    }

    private final void createFenetre(int x, int y) {
        panneau = new PanneauPrincipal();

        setLayout(new BorderLayout());

        add(panneau, BorderLayout.CENTER);

        Command zoomImage = new Zoom(perspective);
        Command translateImage = new Translate(perspective);
        Command undoChange = new Undo();
        Command redoChange = new Redo();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(DIMENSION);
        setVisible(true);
        setLocation(x,y);
        setResizable(false);

        this.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                perspective.setMouseReleased(false);
                // on set la position de la souris lorsqu'on appuie (sans
                // relacher)
                perspective.setStartPoint(e.getPoint());
            }

            public void mouseReleased(MouseEvent e) {
                perspective.setMouseReleased(true);
                perspective.setEndPoint(e.getPoint());
                translateImage.execute();
//                Perspective copyPerspective = new Perspective(perspective);
//                Point2D startVal = (Point2D) perspective.getStartPoint().clone();
//                Point2D endVal = (Point2D) perspective.getEndPoint().clone();
//                double xOffset = perspective.getXOffset();
//                double yOffset = perspective.getYOffset();
                AppState appState = new AppState(perspective, translateImage);
                Mementos.getInstance().setCurrentAppState(appState);
            }

        });

        this.addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                perspective.setEndPoint(e.getPoint());
                // set mouse position after dragging
                translateImage.execute();

            }
        });

        this.addMouseWheelListener(new MouseWheelListener() {

            /**
             * La commande zoom est invoqué en activant la roulette de la
             * souris lorsqu'on maintient la touche CTRL
             * @param e l'évenement qui déclenche la méthode
             */
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.isControlDown()){

                    // set mouse position
                    perspective.setCenterPoint(e.getPoint());

                    // zoom in = x 1.1
                    // zoom out = / 1.1
                    double newScaleValue = e.getWheelRotation() < 0 ?
                            perspective.getScale() * 1.1 : perspective.getScale() / 1.1;

                    // on set le nouveau facteur de zoom
                    perspective.setScale(newScaleValue);
                    zoomImage.execute();
                }
            }
        });

        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                //TODO : Set KeyTypedEvents (if any)
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if((e.getKeyCode() == KeyEvent.VK_Z)  && e.isControlDown()){
                    undoChange.execute();
                }
                if((e.getKeyCode() == KeyEvent.VK_Y)  && e.isControlDown()){
                    redoChange.execute();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //TODO : Set KeyReleasedEvents (if any)
            }
        });
    }

    @Override
    public void update() {
        // pour afficher l'image qu'on a chargé
        if (panneau.getBackgroundImage() == null){
            panneau.setBackgroundImage(bgImage.getImage());
        }
        // pour appliquer les transformations
        else{
            panneau.setAffineTransform(perspective.getAt());
        }
        repaint();
    }
}
