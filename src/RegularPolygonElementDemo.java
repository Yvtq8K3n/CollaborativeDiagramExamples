import collaborative.diagram.Connector.Connector;
import collaborative.diagram.DiagramPanel;
import collaborative.diagram.Element.Polygon;
import collaborative.diagram.Representation.Representation;
import org.json.JSONException;

import javax.swing.*;

public class RegularPolygonElementDemo {

    public static void main(String[] args) throws JSONException {
        DiagramPanel panel = new DiagramPanel();

        //List Regular Polygons
        for (int i = 0; i < 11; i++) {
            Polygon polygon = Polygon.generateRegularPolygon("PR"+i, i+3, 0);
            Representation rep = new Representation("repPR"+i, polygon, i%4*100 + 15 , i/4 * 100 +15, 100, 100);
            panel.add(rep);
        }

        //Rotated Polygon
        Polygon rotated = Polygon.generateRegularPolygon("PR4rotated", 4, Math.PI/4);
        Representation rep = new Representation("repPR4rotated", rotated, 315 , 215, 100, 100);
        panel.add(rep);

        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.add(panel);
    }
}
