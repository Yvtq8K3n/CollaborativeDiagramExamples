import collaborative.diagram.DiagramPanel;
import collaborative.diagram.Element.Polygon;
import collaborative.diagram.Representation.Representation;
import org.json.JSONException;

import javax.swing.*;

public class OfflineRepresentationDemo {
    public static void main(String[] args) throws JSONException {
        Polygon.Triangle triangle = new Polygon.Triangle.Equilateral("name",1);
        Representation representation = new Representation("repTriangle", triangle,
                100, 100, 100, 100);

        DiagramPanel panel = new DiagramPanel();
        panel.add(representation);

        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.add(panel);
    }
}

