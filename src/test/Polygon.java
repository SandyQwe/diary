package test;

/*
        Многоугольник, прототип грядки на карте
        Объект, который в содержит координаты углов на условной карте
        Можно в него напихать ещё кучу всякого.
 */

import java.awt.*;
import java.util.LinkedList;

class Polygon {
    private LinkedList<Dimension> corners;
    private int cornersQty;

    Polygon(int x, int y) {
        corners = new LinkedList<>();
        corners.add(new Dimension(x, y));
        cornersQty = 1;
    }

    void addPoint(int x, int y) {
        corners.add(new Dimension(x,y));
        cornersQty++;
    }

    Dimension getFirstPoint() {
        return corners.get(0);
    }

    LinkedList<Dimension> getCorners() {
        return corners;
    }

    int getCornersQty () {
        return cornersQty;
    }


}
