package controller;

import model.Perspective;

public class Translate implements Command
{
    private Perspective model;

    public Translate (Perspective model){
        this.model = model;
    }

    @Override
    public void execute()
    {
        model.translateImage();
    }

    @Override
    public void changeModel(Perspective model) {
        this.model = model;
    }
}
