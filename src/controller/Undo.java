package controller;

import model.Perspective;
import state.AppState;
import singleton.Mementos;

public class Undo implements Command
{

    private Perspective model;

    @Override
    public void execute()
    {
        if(Mementos.getInstance().canUndo()) {
            AppState previousState = Mementos.getInstance().getPreviousState();

            this.model = previousState.getPerspective();
            if(!previousState.isZoom()){
                model.setEndPoint(previousState.getStartVal());
                model.setStartPoint(previousState.getEndVal());
            }
            else{
                previousState.getCenterVal().setLocation(previousState.getCenterVal().getX() + 8, previousState.getCenterVal().getY());
                model.setCenterPoint(previousState.getCenterVal());
                model.setScale(previousState.getPreviousScale());
            }
            previousState.getCommand().changeModel(model);
            previousState.getCommand().execute();
        }
    }

    @Override
    public void changeModel(Perspective model) {

    }
}