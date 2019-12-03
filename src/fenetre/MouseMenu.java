package fenetre;

import command.Command;
import command.Zoom;
import model.Perspective;
import singleton.AppState;
import singleton.Mementos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseMenu extends JPopupMenu {
    private Perspective perspectiveModel;
    private Command zoomCommand;
    private Point mouseLocation;
    private JMenuItem zoomIn;
    private JMenuItem zoomOut;

    public MouseMenu(Perspective perspectiveModel, Command zoomCommand) {
        this.perspectiveModel = perspectiveModel;
        this.zoomCommand = zoomCommand;
        zoomIn = new JMenuItem("Zoom in");
        zoomIn.addActionListener(menuListener);
        add(zoomIn);
        setInheritsPopupMenu(true);
    }

    public void setMouseLocation(Point mouseLocation) {
        this.mouseLocation = mouseLocation;
    }

    private ActionListener menuListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand() == "Zoom in") {
                perspectiveModel.setCenterPoint(mouseLocation);
                perspectiveModel.setScale(perspectiveModel.getScale() / 1.5);
                zoomCommand.execute();
                AppState appState = new AppState(perspectiveModel, zoomCommand, true);
                Mementos.getInstance().setCurrentAppState(appState);
            }
        }
    };
}
