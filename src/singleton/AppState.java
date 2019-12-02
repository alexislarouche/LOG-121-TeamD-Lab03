package singleton;

import command.Command;
import mvc.Perspective;

import java.awt.*;
import java.util.Stack;

public class AppState
{
    private Perspective perspective;
    private Image image;
    private Command command;

    public AppState(Perspective perspective, Image image, Command command){
        this.perspective = perspective;
        this.image = image;
        this.command = command;
    }

    public Perspective getPerspective() {
        return perspective;
    }

    public Command getCommand() {
        return command;
    }

    public Image getImage() {
        return image;
    }
}
