package mvc;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class Perspective extends Observable{
    private Point2D centerPoint;
    private double scale = 1.0f;
    private BufferedImage image;
    private AffineTransform at;


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
