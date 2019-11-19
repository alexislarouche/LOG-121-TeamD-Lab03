package fenetre;


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


    /**
     * Constructeur de la barre outils
     */
    BarOutils(){
        ajouterMenuFichier();
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
            ouvrirImage();
        });

        menuFichier.add(menuOuvrir);

        this.add(menuFichier);
    }


    /**
     * Ouverture d'une image à l'aide d'un JFileChooser
     * @return null
     */
    public void ouvrirImage(){
        //Creation du fileChooser
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Sélectionnez l'image à ouvrir");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setApproveButtonText("Ouvrir");

        //Creation des filtres
        FileNameExtensionFilter filterPng = new FileNameExtensionFilter("Image PNG","png");
        FileNameExtensionFilter filterJpg = new FileNameExtensionFilter("Image JPG","jpg");
        //Application des filtres
        fileChooser.addChoosableFileFilter(filterPng);
        fileChooser.addChoosableFileFilter(filterJpg);


        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {

            File selectedFile = fileChooser.getSelectedFile();
            if(selectedFile.canRead()){
                try {
                    Image image = ImageIO.read(selectedFile);
                    //TODO : Set the image as the Main picture of the application
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
    }

}
