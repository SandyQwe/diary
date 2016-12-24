package test;

/*
        Панелька, на которой рисуются многоугольники

 */

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

class DrawPanel extends JPanel {
    private LinkedList<Polygon> polygons;

    DrawPanel(LinkedList<Polygon> polygons) {
        setBackground(Color.WHITE);
        this.polygons = polygons;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Polygon polygon : polygons) {
            for (int i = 0; i < polygon.getCorners().size() - 1; i++) {
                g.drawLine((int) polygon.getCorners().get(i).getWidth(),
                        (int) polygon.getCorners().get(i).getHeight(),
                        (int) polygon.getCorners().get(i + 1).getWidth(),
                        (int) polygon.getCorners().get(i + 1).getHeight());
            }
        }
    }
}
