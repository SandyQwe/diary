package test;

/*
    Окошко, куда добавляется JPanel, на которую сажается MouseListener который отвечает за клики мышкой
     каждый клик мышкой создаёт новый угол в многоугольнике
     если щелчок мышкой произошёл вблизи от первой начальной точки рисования многоугольника,
     многоугольник замыкается, после чего новый щелчок мышки создаёт уже новый многоугольник
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

class TestForm extends JFrame {

    private static final Dimension WINDOW_SIZE = new Dimension(500, 500);
    private static final int POS_X = 800;
    private static final int POS_Y = 300;
    private LinkedList<Polygon> polygons = new LinkedList<>();
    private Dimension currentPoint = new Dimension();
    private boolean newPolygon = true;

    TestForm() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Тестовая рисовалка многоугольников");
        setSize(WINDOW_SIZE);
        setLocation(POS_X, POS_Y);
        setResizable(true);
        DrawPanel drawingFrame = new DrawPanel(polygons);
        add(drawingFrame, BorderLayout.CENTER);
        drawingFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                currentPoint.setSize(e.getX(), e.getY());
                if (newPolygon) {
                    polygons.add(new Polygon((int)currentPoint.getWidth(), (int)currentPoint.getHeight()));
                    newPolygon = false;
                } else {
                    if (polygons.getLast().getCornersQty() >= 3 &&
                            Math.abs(currentPoint.getWidth() - polygons.getLast().getFirstPoint().getWidth()) <= 10 &&
                            Math.abs(currentPoint.getHeight() - polygons.getLast().getFirstPoint().getHeight()) <= 10) {
                        currentPoint.setSize(polygons.getLast().getFirstPoint());
                        polygons.getLast().addPoint((int)currentPoint.getWidth(), (int)currentPoint.getHeight());
                        newPolygon = true;
                    } else {
                        polygons.getLast().addPoint((int)currentPoint.getWidth(), (int)currentPoint.getHeight());
                    }
                }
                drawingFrame.repaint();
            }
        });
        setVisible(true);

    }




}
