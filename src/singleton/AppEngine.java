package singleton;

import fenetre.FenetrePrincipale;
import mvc.ModelImage;

public class AppEngine
{
    public static void main(String args[]){
        ModelImage model = new ModelImage();

        FenetrePrincipale fenetrePrincipale = new FenetrePrincipale(100, 500, model);
        FenetrePrincipale perspective1 = new FenetrePrincipale("Perspective 1",600, 500, model);
        FenetrePrincipale perspective2 = new FenetrePrincipale("Perspective 2", 1100,500, model);

        model.addObserver(fenetrePrincipale);
        model.addObserver(perspective1);
        model.addObserver(perspective2);
    }
}
