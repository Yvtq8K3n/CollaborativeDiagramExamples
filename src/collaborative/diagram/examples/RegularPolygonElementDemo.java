package collaborative.diagram.examples;

import collaborative.diagram.element.Polygon;
import collaborative.diagram.representation.Representation;
import org.json.JSONException;

import javax.swing.*;
import java.awt.*;

public class RegularPolygonElementDemo {

    public static void main(String[] args) throws JSONException {
        JPanel panel = new JPanel(new GridLayout(3, 4));

        //List Regular Polygon
        for (int i = 0; i < 11; i++) {
            Polygon polygon = Polygon.generateRegularPolygon("PR"+i, i+3, 0);
            Representation rep = new Representation("repPR"+i, polygon);
            rep.setPreferredSize(new Dimension(100,100));
            panel.add(rep);
        }

        //Rotated Polygon
        Polygon rotated = Polygon.generateRegularPolygon("PR4rotated", 4, Math.PI/4);
        Representation rep = new Representation("repPR4rotated", rotated);
        rep.setPreferredSize(new Dimension(100,100));
        panel.add(rep);

        JFrame frame = new JFrame(RegularPolygonElementDemo.class.getSimpleName());
        frame.setVisible(true);
        frame.add(panel);
        frame.pack();
    }
}
