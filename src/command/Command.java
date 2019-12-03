package command;

import mvc.Perspective;

public interface Command
{
    void execute();
    void changeModel(Perspective model);
}
