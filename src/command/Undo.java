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
        if(Mementos.getInstance().canUndo()) {
            AppState previousState = Mementos.getInstance().getPreviousState();
            this.model = previousState.getPerspective();
            model.setEndPoint(previousState.getStartVal());
            model.setStartPoint(previousState.getEndVal());
            previousState.getCommand().changeModel(model);
            previousState.getCommand().execute();
        }
    }

    @Override
    public void changeModel(Perspective model) {

    }
}
