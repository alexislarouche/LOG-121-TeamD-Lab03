package command;

import mvc.BackgroundImage;
import mvc.Perspective;
import singleton.AppState;
import singleton.Mementos;

public class LoadImage implements Command {

    private BackgroundImage bgImage;

    public LoadImage(BackgroundImage bgImage) {
        this.bgImage = bgImage;
    }

    @Override
    public void execute()
    {
        bgImage.ouvrirImage();
        AppState appState = new AppState(null,bgImage.getImage(),null);
        Mementos.getInstance().setCurrentAppState(appState);
    }

    @Override
    public void changeModel(Perspective model) {

    }
}
