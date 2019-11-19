package mvc;

public interface Observer
{
    /**
     * Méthode à exécuter lors que l'élément Observable est modifié
     * @param param un objet représentant les paramètres de la méthode
     */
    void update(Object param);
}
