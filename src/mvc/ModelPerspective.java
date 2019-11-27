package mvc;

import java.awt.geom.Point2D;

public class ModelPerspective extends Observable{

    private Point2D centerPoint;
    private double scale;

    public ModelPerspective() {}

    public ModelPerspective(double x, double y, double scale){
        this.centerPoint = new Point2D.Double(x,y);
        this.scale = scale;
    }

    public ModelPerspective(Point2D centerPoint, double scale){
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
}
