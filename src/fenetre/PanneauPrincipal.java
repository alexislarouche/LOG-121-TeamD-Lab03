package fenetre;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class PanneauPrincipal extends JPanel{
    private BufferedImage backgroundImage;
    private AffineTransform affineTransform;

    public void setBackgroundImage(BufferedImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public BufferedImage getBackgroundImage() {
        return backgroundImage;
    }

    public void setAffineTransform(AffineTransform affineTransform) {
        this.affineTransform = affineTransform;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // si pas de transformations, donc on dessine l'image de base
        if (affineTransform == null) {
            g.drawImage(backgroundImage,0,0, this);
        }
        // s'il y a une transformation
        else{
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2.setTransform(affineTransform);

            g2.drawImage(backgroundImage,0,0, this);
        }
    }
}
