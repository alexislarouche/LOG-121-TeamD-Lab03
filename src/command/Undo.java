package command;

import mvc.Perspective;
import singleton.AppState;
import singleton.Mementos;

import java.awt.geom.Point2D;

public class Undo implements Command
{

    private Perspective model;

    @Override
    public void execute()
    {
       AppState previousState = Mementos.getInstance().getPreviousState();
       this.model = previousState.getPerspective();
        Point2D temp2DPoint = model.getEndPoint();
        model.setEndPoint(model.getStartPoint());
        model.setStartPoint(temp2DPoint);
        previousState.getCommand().changeModel(model);
        previousState.getCommand().execute();

    }

    @Override
    public void changeModel(Perspective model) {

    }
}
