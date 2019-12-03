package model;

import observer.Observable;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class Perspective extends Observable {
    private Point2D centerPoint;
    private Point2D startPoint;
    private Point2D endPoint;
    private double  xOffset, yOffset;
    private double scale = 1;
    private double previousScale = 1;
    private BufferedImage image;
    private AffineTransform at;
    private boolean mouseReleased;

    public Perspective(){};

    public Perspective(double x, double y, double scale){
        this.centerPoint = new Point2D.Double(x,y);
        this.scale = scale;
    }

    public Perspective(Point2D centerPoint, double scale){
        this.centerPoint = centerPoint;
        this.scale = scale;
    }

    public Point2D getCenterPoint()
    {
        return centerPoint;
    }

    public Point2D getStartPoint() {
        return startPoint;
    }

    public Point2D getEndPoint() {
        return endPoint;
    }

    public void setCenterPoint(Point2D centerPoint)
    {
        this.centerPoint = centerPoint;
    }

    public void setStartPoint(Point2D startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Point2D endPoint) {
        this.endPoint = endPoint;
    }

    public double getScale()
    {
        return scale;
    }

    public double getPreviousScale() {
        return previousScale;
    }

    public void setPreviousScale(double previousScale) {
        this.previousScale = previousScale;
    }

    public void setScale(double scale)
    {
        this.scale = scale;
    }

    public void setMouseReleased(Boolean mouseStatus){
        this.mouseReleased = mouseStatus;
    }

    public AffineTransform getAt(){ return  at;}

    public void setImage(BufferedImage image)
    {
        this.image = image;
        super.notifyObservers();
    }

    public double getXOffset(){
        return xOffset;
    }

    public double getYOffset() {
        return yOffset;
    }

    /**
     * On notify les observers avec une image et sa transformation
     * @param image L'image qu'on veut retracer
     * @param at La transformation qu'on veut effectuer sur l'image
     */
    public void setImageWithTransformation(BufferedImage image, AffineTransform at){
        this.image = image;
        this.at = at;
        super.notifyObservers();
    }

    /**
     * Command Zoom
     * Créé les transformations matricielles nécessaires pour effectuer un zoom
     */
    public void zoomImage() {
        // adjust because of toolbar and blank space between each view
        double adjustedX =  centerPoint.getX() - 8;
        double adjustedY =  centerPoint.getY();

        // ratio entre l'ancien facteur et le facteur courant de zoom
        double scaleDiv = scale / previousScale;

        // calcul pour trouver la valeur precis pour la translation, emprunté de
        // https://stackoverflow.com/questions/6543453/zooming-in-and-zooming-out-within-a-panel
        xOffset = scaleDiv * xOffset + (1 - scaleDiv) * adjustedX;
        yOffset = scaleDiv * yOffset + (1 - scaleDiv) * adjustedY;

        // transformation de matrice
        AffineTransform at = new AffineTransform();
        at.translate(xOffset, yOffset);
        at.scale(scale, scale);

        previousScale = scale;

        // On envoit l'image et la transformation pour se faire repaint
        setImageWithTransformation(image, at);
    }

    /**
     * Command Translate
     * Créé les transformations matricielles nécessaires pour effectuer une
     * translation en x/y
     */
    public void translateImage(){

        // Distance entre le point d'appuie et le point courant, lorsqu'on
        // traine la souris
        double x = getEndPoint().getX() - getStartPoint().getX();
        double y = getEndPoint().getY() - getStartPoint().getY();

        // transformation de matrice
        AffineTransform at = new AffineTransform();
        at.translate(x + xOffset,y + yOffset);
        at.scale(scale, scale);

        // si la souris est lachée
        if (mouseReleased){
            xOffset += x;
            yOffset += y;
        }

        // On envoit l'image et la transformation pour se faire repaint
        setImageWithTransformation(image, at);
    }
}
