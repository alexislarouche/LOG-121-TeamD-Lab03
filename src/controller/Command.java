package controller;

import model.Perspective;

public interface Command
{
    void execute();
    void changeModel(Perspective model);
}
