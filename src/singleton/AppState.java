package singleton;

import command.Command;
import mvc.Perspective;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Stack;

public class AppState
{
    private Perspective perspective;
    private Point2D startVal;
    private Point2D endVal;

    private Command command;

    public AppState(Perspective perspective, Command command) {

        this.perspective = perspective;
        startVal = (Point2D) perspective.getStartPoint().clone();
        endVal = (Point2D) perspective.getEndPoint().clone();

        this.command = command;
    }

    public Point2D getStartVal(){
        return startVal;
    }

    public Point2D getEndVal(){
        return endVal;
    }

    public Perspective getPerspective() {
        return perspective;
    }

    public Command getCommand() {
        return command;
    }
}
