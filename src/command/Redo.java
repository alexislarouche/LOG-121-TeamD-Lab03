package command;

import mvc.Perspective;
import singleton.AppState;
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
            model.setEndPoint(previousState.getEndVal());
            model.setStartPoint(previousState.getStartVal());
            previousState.getCommand().changeModel(model);
            previousState.getCommand().execute();
        }
    }

    @Override
    public void changeModel(Perspective model) {

    }
}
