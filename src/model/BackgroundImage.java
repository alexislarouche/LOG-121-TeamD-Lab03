package model;

import observer.Observable;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundImage extends Observable {
    private BufferedImage image;

    public BufferedImage getImage()
    {
        return image;
    }

    public void setImage(BufferedImage image)
    {
        this.image = image;
        super.notifyObservers();
    }

    /**
     * Ouverture d'une image à l'aide d'un JFileChooser
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
                    setImage(ImageIO.read(selectedFile));
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
