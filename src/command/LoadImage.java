package command;

import mvc.BackgroundImage;

public class LoadImage implements Command {

    private BackgroundImage bgImage;

    public LoadImage(BackgroundImage bgImage) {
        this.bgImage = bgImage;
    }

    @Override
    public void execute()
    {
        bgImage.ouvrirImage();
    }
}
