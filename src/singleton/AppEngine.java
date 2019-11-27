package singleton;

import fenetre.FenetrePerspective;
import fenetre.FenetrePrincipale;
import mvc.Model;

public class AppEngine
{
    public static void main(String args[]){
        Model model = new Model();

        FenetrePrincipale fenetrePrincipale = new FenetrePrincipale(100, 500, model);
        FenetrePerspective fenetrePerspective1 = new FenetrePerspective("Perspective 1",600, 500, model);
        FenetrePerspective fenetrePerspective2 = new FenetrePerspective("Perspective 2", 1100,500, model);

        model.addObserver(fenetrePrincipale);
        model.addObserver(fenetrePerspective1);
        model.addObserver(fenetrePerspective2);
    }
}
