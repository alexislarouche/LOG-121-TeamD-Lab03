package view;


import controller.Command;
import controller.Load;
import controller.Save;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;

/**
 * Bar de Menu dans la fenêtre principale
 */
public class BarOutils extends JMenuBar {

    private static final long serialVersionUID = 1L;
    private static final String MENU_FICHIER_TITRE = "Fichier";
    private static final String MENU_FICHIER_OUVRIR = "Ouvrir Image";
    private Command commandLoadImage;
    private Command commandSave;
    private Command commandLoadConfig;

    BarOutils(){
    }

    /**
     * Constructeur de la barre outils
     */
    BarOutils(Command commandLoadImage, Command commandSave, Command commandLoadConfig){
        ajouterMenuFichier();
        this.commandLoadImage = commandLoadImage;
        this.commandSave = commandSave;
        this.commandLoadConfig = commandLoadConfig;
    }

    /**
     * Ajoute le menu fichier avec les différentes options d'ouveture
     * de sauvegarde et de chargement de fichier
     * @return null
     */
    public void ajouterMenuFichier(){
        JMenu menuFichier = new JMenu(MENU_FICHIER_TITRE);
        JMenuItem menuOuvrir = new JMenuItem(MENU_FICHIER_OUVRIR);
        JMenuItem menuSave = new JMenuItem("Sauvegarder configuration");
        JMenuItem menuLoad = new JMenuItem("Charger configuration...");

        menuLoad.addActionListener((ActionEvent e) -> {
            JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Configuration cfg","xml");
            fc.addChoosableFileFilter(filter);
            int resp = fc.showOpenDialog(null);
            if(resp == JFileChooser.APPROVE_OPTION){
                ((Load)commandLoadConfig).setFile(fc.getSelectedFile());
                commandLoadConfig.execute();
            }
        });

        menuSave.addActionListener((ActionEvent e) -> {
            JFileChooser fc = new JFileChooser();
            int resp = fc.showOpenDialog(null);
            if(resp == JFileChooser.APPROVE_OPTION){
                String configName = fc.getName();
                ((Save)commandSave).setName(configName);
                commandSave.execute();
            }
        });

        menuOuvrir.addActionListener((ActionEvent e) -> {
            commandLoadImage.execute();
        });

        menuFichier.add(menuOuvrir);
        menuFichier.add(menuSave);
        menuFichier.add(menuLoad);

        this.add(menuFichier);
    }
}
