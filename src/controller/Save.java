package controller;

import model.Perspective;
import app.AppConfig;
import app.SerializabaleAppConfig;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.beans.XMLEncoder;
import java.io.*;

public class Save implements Command
{
    AppConfig config;

    public Save(AppConfig config){
        this.config = config;
    }

    @Override
    public void execute()
    {
        if(config == null){

        }
        else{
                byte[] binaryPicture = null;
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                try {
                    ImageIO.write((BufferedImage) config.getBackgroundImage().getImage(), "png", bos);
                    binaryPicture = bos.toByteArray();
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }

                SerializabaleAppConfig serializabaleAppConfig = new SerializabaleAppConfig(config.getName(), binaryPicture, config.getPerspective1(), config.getPerspective2());

                XMLEncoder encoder=null;
                try{
                    encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Config.xml")));
                }catch(FileNotFoundException fileNotFound){
                    System.out.println("ERROR: While Creating or Opening the File dvd.xml");
                }
                if(encoder != null)
                {
                    encoder.writeObject(serializabaleAppConfig);
                    encoder.close();
                }
        }

    }

    @Override
    public void changeModel(Perspective model) {

    }

    public void setConfig(AppConfig config)
    {
        this.config = config;
    }

    public void setName(String name){
        config.setName(name);
    }

}
