package app;

import model.BackgroundImage;
import model.Perspective;

public class AppConfig
{
    Perspective perspective1;
    Perspective perspective2;
    BackgroundImage backgroundImage;
    String name;

    public AppConfig(){}

    public AppConfig(String name, BackgroundImage backgroundImage, Perspective perspective1, Perspective perspective2){
        this.name = name;
        this.perspective1 = perspective1;
        this.perspective2 = perspective2;
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

    public BackgroundImage getBackgroundImage()
    {
        return backgroundImage;
    }

    public void setBackgroundImage(BackgroundImage backgroundImage)
    {
        this.backgroundImage = backgroundImage;
    }

}
