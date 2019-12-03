package app;

import view.FenetrePerspective;
import view.FenetrePrincipale;
import model.BackgroundImage;
import model.Perspective;

public class AppEngine
{
    public static void main(String args[]){
        BackgroundImage bgImage = new BackgroundImage();
        Perspective p1 = new Perspective();
        Perspective p2 = new Perspective();

        FenetrePrincipale fenetrePrincipale = new FenetrePrincipale(100, 500, bgImage);
        FenetrePerspective fenetrePerspective1 = new FenetrePerspective("Perspective 1",600, 500, bgImage, p1);
        FenetrePerspective fenetrePerspective2 = new FenetrePerspective("Perspective 2", 1100,500, bgImage, p2);

        bgImage.addObserver(fenetrePrincipale);
        bgImage.addObserver(fenetrePerspective1);
        bgImage.addObserver(fenetrePerspective2);

        p1.addObserver(fenetrePerspective1);
        p2.addObserver(fenetrePerspective2);
    }
}
