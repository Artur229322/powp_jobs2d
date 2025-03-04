package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;


import static edu.kis.powp.jobs2d.features.DrawerFeature.getDrawerController;

public class LineDrawerAdapter implements Job2dDriver {
    private int startX = 0, startY = 0;

    public LineDrawerAdapter() {
        super();
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line = LineFactory.getSpecialLine();
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        DrawPanelController drawerController = getDrawerController();
        drawerController.drawLine(line);
        setPosition(x,y);
    }

    @Override
    public String toString() {
        return "LineDrawerAdapter";
    }
}
