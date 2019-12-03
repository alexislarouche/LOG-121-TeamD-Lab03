package view;

import controller.Command;
import model.Perspective;
import singleton.AppState;
import singleton.Mementos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseMenu extends JPopupMenu {
    private Perspective perspectiveModel;
    private Command zoomCommand;
    private Command undoCommand;
    private Command redoCommand;
    private Point mouseLocation;
    private JMenuItem zoomIn;
    private JMenuItem zoomOut;
    private JMenuItem undoChange;
    private JMenuItem redoChange;
    private final String undoText = "Undo";
    private final String redoText = "Redo";
    private final String zoomInText = "Zoom-in";
    private final String zoomOutText = "Zoom-out";


    public MouseMenu(Perspective perspectiveModel, Command zoom, Command undo, Command redo) {
        this.perspectiveModel = perspectiveModel;
        this.zoomCommand = zoom;
        this.undoCommand = undo;
        this.redoCommand = redo;

        zoomIn = new JMenuItem(zoomInText);
        zoomIn.addActionListener(menuListener);
        add(zoomIn);

        zoomOut = new JMenuItem(zoomOutText);
        zoomOut.addActionListener(menuListener);
        add(zoomOut);

        undoChange = new JMenuItem(undoText);
        undoChange.addActionListener(menuListener);
        add(undoChange);

        redoChange = new JMenuItem(redoText);
        redoChange.addActionListener(menuListener);
        add(redoChange);

        setInheritsPopupMenu(true);
    }

    public void setMouseLocation(Point mouseLocation) {
        this.mouseLocation = mouseLocation;
    }

    private ActionListener menuListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            AppState appState;
            perspectiveModel.setCenterPoint(mouseLocation);

            switch (e.getActionCommand()) {
                case zoomInText :
                    perspectiveModel.setScale(perspectiveModel.getScale() * 1.5);
                    zoomCommand.execute();
                    appState = new AppState(perspectiveModel, zoomCommand, true);
                    Mementos.getInstance().setCurrentAppState(appState);
                    break;
                case zoomOutText :
                    perspectiveModel.setScale(perspectiveModel.getScale() / 1.5);
                    zoomCommand.execute();
                    appState = new AppState(perspectiveModel, zoomCommand, true);
                    Mementos.getInstance().setCurrentAppState(appState);
                    break;
                case redoText :
                    redoCommand.execute();
                    break;
                case undoText :
                    undoCommand.execute();
                    break;
            }
        }
    };
}
