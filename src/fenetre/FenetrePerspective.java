package fenetre;

import mvc.BackgroundImage;
import mvc.Observer;
import mvc.Perspective;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

        //BarOutils barreOutils = new BarOutils();

        setLayout(new BorderLayout());

        add(panneau, BorderLayout.CENTER);
        //add(barreOutils, BorderLayout.NORTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(DIMENSION);
        setVisible(true);
        setLocation(x,y);
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
                if (e.isControlDown()){

                    // set mouse position
                    perspective.setCenterPoint(e.getPoint());

                    // zoom in = x 1.1
                    // zoom out = / 1.1
                    double newScaleValue = e.getWheelRotation() < 0 ?
                            perspective.getScale() * 1.1 : perspective.getScale() / 1.1;

                    perspective.setScale(newScaleValue);
                    perspective.zoomImage();
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
        if (panneau.getBackgroundImage() == null){
            panneau.setBackgroundImage(bgImage.getImage());
        }
        else{
            panneau.setAffineTransform(perspective.getAt());
        }
        repaint();
    }
}
