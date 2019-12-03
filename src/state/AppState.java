package state;

import controller.Command;
import model.Perspective;

import java.awt.geom.Point2D;

public class AppState
{
    private Perspective perspective;
    private Point2D startVal;
    private Point2D endVal;
    private Point2D centerVal;
    private double scale;
    private double previousScale;
    private boolean isZoom;
    private Command command;

    public AppState(Perspective perspective, Command command, boolean isZoom) {
        this.isZoom = isZoom;
        this.perspective = perspective;
        if(this.isZoom){
            centerVal = (Point2D) perspective.getCenterPoint().clone();
            scale = perspective.getScale();
            previousScale = perspective.getPreviousScale();
        }
        else{
//            if(perspective)
            startVal = (Point2D) perspective.getStartPoint().clone();
            endVal = (Point2D) perspective.getEndPoint().clone();
        }

        this.command = command;
    }

    public boolean isZoom(){
        return isZoom;
    }

    public Point2D getStartVal(){
        return startVal;
    }

    public Point2D getEndVal(){
        return endVal;
    }

    public Point2D getCenterVal() {
        return centerVal;
    }

    public double getScale() {
        return scale;
    }

    public double getPreviousScale() {
        return previousScale;
    }

    public void initialScale(){
        this.previousScale = 1;
    }

    public Perspective getPerspective() {
        return perspective;
    }

    public Command getCommand() {
        return command;
    }
}
