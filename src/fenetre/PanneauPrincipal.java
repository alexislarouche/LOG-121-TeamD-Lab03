package fenetre;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PanneauPrincipal extends JPanel{
    private BufferedImage backgroundImage;

    public void setBackgroundImage(BufferedImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(backgroundImage,0,0, this);
    }

}
