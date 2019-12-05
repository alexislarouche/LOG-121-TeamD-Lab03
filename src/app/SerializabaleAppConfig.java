package app;

import com.sun.xml.internal.ws.developer.Serialization;
import model.Perspective;

import java.io.Serializable;

public class SerializabaleAppConfig implements Serializable
{
    @Serialization
    Perspective perspective1;
    Perspective perspective2;
    byte[] backgroundImage;
    String name;

    public SerializabaleAppConfig(){}

    public SerializabaleAppConfig(String name, byte[] backgroundImage, Perspective perspective1, Perspective perspective2){
        this.name = name;
        this.perspective1 = perspective1;
        this.perspective2 = perspective2;
        this.backgroundImage = backgroundImage;
        this.perspective1.setImage(null);
        this.perspective2.setImage(null);
    }

    public Perspective getPerspective1()
    {
        return perspective1;
    }

    public void setPerspective1(Perspective perspective1)
    {
        this.perspective1 = perspective1;
    }

    public Perspective getPerspective2()
    {
        return perspective2;
    }

    public void setPerspective2(Perspective perspective2)
    {
        this.perspective2 = perspective2;
    }

    public byte[] getBackgroundImage()
    {
        return backgroundImage;
    }

    public void setBackgroundImage(byte[] backgroundImage)
    {
        this.backgroundImage = backgroundImage;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
