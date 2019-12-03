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

        zoomOut = new JMenuItem("Zoom out");
        zoomOut.addActionListener(menuListener);
        add(zoomOut);

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
                case "Zoom in" :
                    perspectiveModel.setScale(perspectiveModel.getScale() * 1.5);
                    zoomCommand.execute();
                    appState = new AppState(perspectiveModel, zoomCommand, true);
                    Mementos.getInstance().setCurrentAppState(appState);
                    break;
                case "Zoom out" :
                    perspectiveModel.setScale(perspectiveModel.getScale() / 1.5);
                    zoomCommand.execute();
                    appState = new AppState(perspectiveModel, zoomCommand, true);
                    Mementos.getInstance().setCurrentAppState(appState);
                    break;
            }
        }
    };
}
