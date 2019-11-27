package command;

import mvc.Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadImage implements Command {

    private Model model;

    public LoadImage(Model model) {
        this.model = model;
    }

    @Override
    public void execute()
    {
        model.ouvrirImage();
    }
}
