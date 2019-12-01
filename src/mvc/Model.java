package mvc;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class Model extends Observable {
    private Point2D centerPoint;
    private double scale = 1.0f;
    private BufferedImage image;
    private AffineTransform at;

    public Model() {}

    public Model(double x, double y, double scale){
        this.centerPoint = new Point2D.Double(x,y);
        this.scale = scale;
    }

    public Model(Point2D centerPoint, double scale){
        this.centerPoint = centerPoint;
        this.scale = scale;
    }

    public Point2D getCenterPoint()
    {
        return centerPoint;
    }

    public void setCenterPoint(Point2D centerPoint)
    {
        this.centerPoint = centerPoint;
    }

    public double getScale()
    {
        return scale;
    }

    public void setScale(double scale)
    {
        this.scale = scale;
    }

    public BufferedImage getImage()
    {
        return image;
    }

    public AffineTransform getAt(){ return  at;}

    public void setImage(BufferedImage image)
    {
        this.image = image;
        super.notifyObservers();
    }

    public void setImageWithTransformation(BufferedImage image, AffineTransform at){
        this.image = image;
        this.at = at;
        super.notifyObservers();
    }

    /**
     * Ouverture d'une image à l'aide d'un JFileChooser
     */
    public void ouvrirImage(){
        //Creation du fileChooser
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Sélectionnez l'image à ouvrir");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setApproveButtonText("Ouvrir");

        //Creation des filtres
        FileNameExtensionFilter filterPng = new FileNameExtensionFilter("Image PNG","png");
        FileNameExtensionFilter filterJpg = new FileNameExtensionFilter("Image JPG","jpg");
        //Application des filtres
        fileChooser.addChoosableFileFilter(filterPng);
        fileChooser.addChoosableFileFilter(filterJpg);


        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {

            File selectedFile = fileChooser.getSelectedFile();
            if(selectedFile.canRead()){
                try {
                    setImage(ImageIO.read(selectedFile));
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void zoomImage() {

        // adjust because of toolbar and blank space between each view
        double adjustedX =  centerPoint.getX() - 8;
        double adjustedY =  centerPoint.getY() - 53;

        AffineTransform at = new AffineTransform();
        at.translate(adjustedX, adjustedY);
        at.scale(scale, scale);
        at.translate(-adjustedX, -adjustedY);

        setImageWithTransformation(image, at);
    }
}
