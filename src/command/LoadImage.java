package command;

import mvc.Model;
import mvc.ModelImage;

public class LoadImage implements Command {

    private ModelImage model;

    public LoadImage(ModelImage model) {
        this.model = model;
    }

    @Override
    public void execute()
    {
        model.ouvrirImage();
    }
}
