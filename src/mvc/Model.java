package mvc;

import java.awt.*;
import java.awt.geom.Point2D;

public class Model extends Observable
{
    private Point2D centerPoint;
    private double scale;
    private Image image;

    public Model() {}

    public Model(double x, double y, double scale){
        this.centerPoint = new Point2D.Double(x,y);
        this.scale = scale;
    }

    public Model(Point2D centerPoint, double scale){
        this.centerPoint = centerPoint;
        this.scale = scale;
    }

    public Model(double x, double y, double scale, Image image){
        this.centerPoint = new Point2D.Double(x,y);
        this.scale = scale;
        this.image = image;
    }

    public Model(Point2D centerPoint, double scale, Image image){
        this.centerPoint = centerPoint;
        this.scale = scale;
        this.image = image;
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

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }
}
