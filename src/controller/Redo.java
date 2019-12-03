package controller;

import model.Perspective;
import app.AppState;
import singleton.Mementos;

public class Redo implements Command
{
    private Perspective model;

    @Override
    public void execute()
    {
        if(Mementos.getInstance().canRedo()) {

            AppState previousState = Mementos.getInstance().getUndoState();
            this.model = previousState.getPerspective();
            if(!previousState.isZoom()) {
                model.setEndPoint(previousState.getEndVal());
                model.setStartPoint(previousState.getStartVal());
            }
            else {
                previousState.getCenterVal().setLocation(previousState.getCenterVal().getX() - 8, previousState.getCenterVal().getY());
                model.setCenterPoint(previousState.getCenterVal());
                model.setScale(previousState.getScale());
            }
            previousState.getCommand().changeModel(model);
            previousState.getCommand().execute();
        }
    }

    @Override
    public void changeModel(Perspective model) {

    }
}
