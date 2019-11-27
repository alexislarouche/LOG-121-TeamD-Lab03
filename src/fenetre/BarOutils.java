package fenetre;


import command.Command;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

/**
 * Bar de Menu dans la fenêtre principale
 */
public class BarOutils extends JMenuBar {

    private static final long serialVersionUID = 1L;
    private static final String MENU_FICHIER_TITRE = "Fichier";
    private static final String MENU_FICHIER_OUVRIR = "Ouvrir Image";
    private Command commandLoadImage;


    /**
     * Constructeur de la barre outils
     */
    BarOutils(Command commandLoadImage){
        ajouterMenuFichier();
        this.commandLoadImage = commandLoadImage;
    }

    /**
     * Ajoute le menu fichier avec les différentes options d'ouveture
     * de sauvegarde et de chargement de fichier
     * @return null
     */
    public void ajouterMenuFichier(){
        JMenu menuFichier = new JMenu(MENU_FICHIER_TITRE);
        JMenuItem menuOuvrir = new JMenuItem(MENU_FICHIER_OUVRIR);

        menuOuvrir.addActionListener((ActionEvent e) -> {
            commandLoadImage.execute();
        });

        menuFichier.add(menuOuvrir);

        this.add(menuFichier);
    }
}
