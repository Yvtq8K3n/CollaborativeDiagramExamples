import collaborative.diagram.DiagramPanel;
import collaborative.diagram.Element.Composed;
import collaborative.diagram.Element.Composed.ElementSlot;
import collaborative.diagram.Element.Ellipse;
import collaborative.diagram.Element.Polygon.Rectangle;
import collaborative.diagram.Representation.Representation;
import org.json.JSONException;

import javax.swing.*;
import java.net.URISyntaxException;

import static collaborative.diagram.DiagramServer.SERVER;

public class ComposedElementDemo {
    public static void main(String[] args) throws URISyntaxException, JSONException, IllegalAccessException {
        SERVER.createConnection("http://localhost", 8080, "John Marquez");

        Ellipse ellipse = new Ellipse.Circle("ellipse1", 0.4f);
        Rectangle rectangle = new Rectangle("rectangle", 0.8f);

        //Create composed element
        Composed composed = new Composed("composed", rectangle);
        composed.addChildren(new ElementSlot(ellipse, Composed.SOUTHEAST, 1));
        composed.addChildren(ellipse, Composed.NORTHWEST, -0.25);
        composed.addChildren(ellipse, Composed.SOUTHWEST, -0.25);
        composed.addChildren(ellipse, Composed.NORTHEAST, -0.25);
        composed.addChildren(ellipse, Composed.SOUTHEAST, -0.25);

        composed.addChildren(ellipse, Composed.WEST, -0.50);
        composed.addChildren(ellipse, Composed.EAST, -0.50);
        composed.addChildren(ellipse, Composed.SOUTH, -0.50);
        composed.addChildren(ellipse, Composed.NORTH, -0.50);

        composed.addChildren(ellipse, Composed.CENTER, 1);


        /*composed.addChildren(ellipse, Composed.SOUTH);
        composed.addChildren(new Composed.ElementSlot(ellipse, Composed.WEST));
        composed.addChildren(ellipse, Composed.EAST);

        composed.addChildren(ellipse, Composed.CENTER);
        */

        //SERVER.addElement(composed);

        Representation representation =  new Representation("rep", composed, 120, 100, 150, 150);

        //SERVER.addElement(composed);
        DiagramPanel panel = new DiagramPanel();
        panel.add(representation);

        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.add(panel);
    }
}
