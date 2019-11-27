package mvc;

import java.awt.geom.Point2D;

public class View implements Observer
{
    protected Point2D position;
    protected double width, height;

    public View(){}

    public View(double x, double y, double width, double height){
        this.position = new Point2D.Double(x,y);
        this.width = width;
        this.height = height;
    }

    public View(Point2D position, double width, double height){
        this.position = position;
        this.width = width;
        this.height = height;
    }

    @Override
    public void update()
    {

    }
}
