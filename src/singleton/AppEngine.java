package singleton;

import fenetre.FenetrePerspective;
import fenetre.FenetrePrincipale;
import mvc.BackgroundImage;
import mvc.Perspective;

public class AppEngine
{
   private static BackgroundImage bgImage;
   private static Perspective p1;
   private static Perspective p2;

    public static void main(String args[]){

        bgImage = new BackgroundImage();
        p1 = new Perspective();
        p2 = new Perspective();

        AppConfig config = new AppConfig("name", bgImage, p1, p2);

        FenetrePrincipale fenetrePrincipale = new FenetrePrincipale(100, 500, bgImage, config);
        FenetrePerspective fenetrePerspective1 = new FenetrePerspective("Perspective 1",600, 500, bgImage,p1);
        FenetrePerspective fenetrePerspective2 = new FenetrePerspective("Perspective 2", 1100,500, bgImage, p2);

        bgImage.addObserver(fenetrePrincipale);
        bgImage.addObserver(fenetrePerspective1);
        bgImage.addObserver(fenetrePerspective2);

        p1.addObserver(fenetrePerspective1);
        p2.addObserver(fenetrePerspective2);
    }

    public static void setBgImage(BackgroundImage bgImage)
    {
        AppEngine.bgImage = bgImage;
    }

    public static void setP1(Perspective p1)
    {
        AppEngine.p1 = p1;
    }

    public static void setP2(Perspective p2)
    {
        AppEngine.p2 = p2;
    }
}
