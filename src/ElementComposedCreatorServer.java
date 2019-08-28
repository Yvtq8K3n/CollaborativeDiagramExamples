import collaborative.diagram.DiagramPanel;
import collaborative.diagram.DiagramServer;
import collaborative.diagram.Element.Composed;
import collaborative.diagram.Element.Element;
import collaborative.diagram.Element.Polygon;
import collaborative.diagram.Representation.Representation;
import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.net.URISyntaxException;

import static collaborative.diagram.DiagramServer.SERVER;

public class ElementComposedCreatorServer {
    public static void main(String[] args) throws URISyntaxException, JSONException, IllegalAccessException {
        SERVER.createConnection("http://localhost", 8080, "Johnny Marquez");
        DiagramPanel panel = new DiagramPanel();

        //Create Simple Element
        Polygon.Rectangle rectangle = new Polygon.Rectangle("rectangle", 0.8f);

        //Create 1st level of Composed
        Composed composed = new Composed("composed", rectangle);
        composed.addChildren(rectangle, Composed.NORTHEAST);

        //Create 2nd level of Composed:D
        Composed composed1 = new Composed("final", rectangle);
        composed1.addChildren(composed, Composed.SOUTHEAST);
        DiagramServer.addElement(composed1);

        //Create representations
        Representation rep= createRep("rep", composed1);
        DiagramServer.addRepresentation(rep);

        //Creating and showing the main frame:
        final JFrame frame = new JFrame(RepresentationCreatorServer.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //The size of the content pane adds some extra room for moving the labels:
        final Dimension paneSize = new Dimension(500, 500);
        frame.getContentPane().setPreferredSize(paneSize);
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static Representation createRep(String name, Element element) throws JSONException {
        Representation representation = new Representation(name, element, 0, 0, 150, 150);
        return representation;
    }

}
