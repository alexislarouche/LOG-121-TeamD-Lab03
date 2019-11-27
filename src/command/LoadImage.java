package command;

import mvc.Model;

public class LoadImage implements Command {

    private Model model;

    public LoadImage(Model model) {
        this.model = model;
    }

    @Override
    public void execute()
    {
        model.ouvrirImage();
    }
}
