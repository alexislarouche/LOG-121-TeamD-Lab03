package command;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import mvc.BackgroundImage;
import mvc.Perspective;
import singleton.AppConfig;
import singleton.SerializabaleAppConfig;

import javax.imageio.ImageIO;
import javax.security.auth.login.Configuration;
import java.awt.image.BufferedImage;
import java.beans.XMLDecoder;
import java.io.*;

public class Load implements Command
{
    AppConfig config;

    File file;

    public Load(AppConfig config){
        this.config = config;
    }

    @Override
    public void execute()
    {
        if(config == null){

        }
        else{
            XMLDecoder decoder=null;
            try {
                decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            SerializabaleAppConfig serializedAppConfig = (SerializabaleAppConfig)decoder.readObject();

            BufferedImage img = null;
            ByteArrayInputStream bis = new ByteArrayInputStream(serializedAppConfig.getBackgroundImage());
            try{
                img = ImageIO.read(bis);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }

            this.config.getBackgroundImage().setImage(img);
            this.config.getPerspective1().replace(serializedAppConfig.getPerspective1());
            this.config.getPerspective2().replace(serializedAppConfig.getPerspective2());
            this.config.getPerspective1().setImage(img);
            this.config.getPerspective2().setImage(img);
            this.config.getPerspective1().notifyObservers();
            this.config.getPerspective2().notifyObservers();
        }

    }

    @Override
    public void changeModel(Perspective model) {

    }

    public void setFile(File file){
        this.file = file;
    }

}
