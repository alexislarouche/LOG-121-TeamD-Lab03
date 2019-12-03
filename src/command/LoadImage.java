package command;

import model.BackgroundImage;
import model.Perspective;

public class LoadImage implements Command {

    private BackgroundImage bgImage;

    public LoadImage(BackgroundImage bgImage) {
        this.bgImage = bgImage;
    }

    @Override
    public void execute()
    {
        bgImage.ouvrirImage();
//        AppState appState = new AppState(null,null);
//        Mementos.getInstance().setCurrentAppState(appState);
    }

    @Override
    public void changeModel(Perspective model) {

    }
}
