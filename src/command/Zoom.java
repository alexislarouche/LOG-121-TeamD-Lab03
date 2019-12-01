package command;

import mvc.Model;

public class Zoom implements Command
{
    private Model model;

    public Zoom(Model model){
        this.model = model;
    }

    @Override
    public void execute()
    {
        model.zoomImage();
    }
}
