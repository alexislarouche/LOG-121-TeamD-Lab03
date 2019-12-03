package fenetre;

import command.*;
import model.BackgroundImage;
import observer.Observer;
import model.Perspective;
import singleton.AppState;
import singleton.Mementos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetrePerspective extends JFrame implements Observer {
    private PanneauPrincipal panneau;
    private Perspective perspectiveModel;
    private BackgroundImage bgImage;
    private MouseMenu mouseMenu;
    private static final Dimension DIMENSION = new Dimension(500, 400);

    public FenetrePerspective(String title, int x, int y, BackgroundImage bgImage,Perspective perspectiveModel) {
        setTitle(title);
        this.perspectiveModel = perspectiveModel;
        this.bgImage = bgImage;
        createFenetre(x, y);
    }

    private final void createFenetre(int x, int y) {

        panneau = new PanneauPrincipal();

        setLayout(new BorderLayout());



        Command zoomImage = new Zoom(perspectiveModel);
        Command translateImage = new Translate(perspectiveModel);
        Command undoChange = new Undo();
        Command redoChange = new Redo();

        mouseMenu = new MouseMenu(perspectiveModel, zoomImage);
        panneau.setComponentPopupMenu(mouseMenu);
        add(panneau, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(DIMENSION);
        setVisible(true);
        setLocation(x,y);
        setResizable(false);

        panneau.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON3)
                    mouseMenu.setMouseLocation(e.getPoint());
                perspectiveModel.setMouseReleased(false);
                // on set la position de la souris lorsqu'on appuie (sans
                // relacher)
                perspectiveModel.setStartPoint(e.getPoint());
            }

            public void mouseReleased(MouseEvent e) {
                perspectiveModel.setMouseReleased(true);
                perspectiveModel.setEndPoint(e.getPoint());
                translateImage.execute();
                AppState appState = new AppState(perspectiveModel, translateImage, false);
                Mementos.getInstance().setCurrentAppState(appState);
            }

        });

        panneau.addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                perspectiveModel.setEndPoint(e.getPoint());
                // set mouse position after dragging
                translateImage.execute();

            }
        });

        panneau.addMouseWheelListener(new MouseWheelListener() {

            /**
             * La commande zoom est invoqué en activant la roulette de la
             * souris lorsqu'on maintient la touche CTRL
             * @param e l'évenement qui déclenche la méthode
             */
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.isControlDown()){

                    // set mouse position
                    perspectiveModel.setCenterPoint(e.getPoint());

                    double newScaleValue = 0;

                    if(e.getWheelRotation() < 0) {
                        newScaleValue = perspectiveModel.getScale() * 1.5;
                    } else {
                        newScaleValue = perspectiveModel.getScale() / 1.5;
                    }

                    // on set le nouveau facteur de zoom
                    perspectiveModel.setScale(newScaleValue);
                    zoomImage.execute();
                    AppState appState = new AppState(perspectiveModel, zoomImage, true);
                    Mementos.getInstance().setCurrentAppState(appState);
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
            panneau.setAffineTransform(perspectiveModel.getAt());
        }
        repaint();
    }
}
