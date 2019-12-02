package command;

import mvc.Perspective;

public class Zoom implements Command
{
    private Perspective model;

    public Zoom(Perspective model){
        this.model = model;
    }

    @Override
    public void execute()
    {
        model.zoomImage();
    }

    @Override
    public void changeModel(Perspective model) {
        this.model = model;
    }
}
