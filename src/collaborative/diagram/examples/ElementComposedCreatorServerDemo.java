package collaborative.diagram.examples;

import collaborative.diagram.*;
import collaborative.diagram.element.*;
import collaborative.diagram.element.Polygon;
import collaborative.diagram.representation.Representation;
import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.net.URISyntaxException;

import static collaborative.diagram.DiagramServer.SERVER;

public class ElementComposedCreatorServerDemo implements NetworkObserver {
    private DiagramPanel panel;

    public static void main(String[] args) throws URISyntaxException {
        DiagramServer.SERVER.createConnection("http://localhost", 9000, "Johnny Marquez");
        new ElementComposedCreatorServerDemo();
    }

    public ElementComposedCreatorServerDemo(){
        panel = new DiagramPanel();

        //Registers to get notified when new elements arrive
        SERVER.addNetworkObserver(this);

        //Creating and showing the main frame:
        final JFrame frame = new JFrame(ElementComposedCreatorServerDemo.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //The size of the content pane adds some extra room for moving the labels:
        frame.setPreferredSize(new Dimension(500, 500));
        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void notifyElementCreation(Element element) {
        if (element.getName().equals("rectangle")) {
            try {
                //Retrieve Existing Rectangle Element
                Polygon.Rectangle rectangle = (Polygon.Rectangle) element;

                //Create 1st level of Composed
                Composed composed = new Composed("composed", rectangle);
                composed.addChildren(rectangle, Composed.NORTHEAST);

                //Create 2nd level of Composed:D
                Composed composed1 = new Composed("final", rectangle);
                composed1.addChildren(composed, Composed.SOUTHEAST);

                //Create representations
                Representation rep = createRep("rep", composed1);
                DiagramServer.addElement(composed1);
                DiagramServer.addRepresentation(rep);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static Representation createRep(String name, Element element) throws JSONException {
        Representation representation = new Representation(name, element, 0, 0, 150, 150);
        return representation;
    }


    @Override
    public void notifyElementAlteration(Element element) {

    }

    @Override
    public void notifyRepresentationCreation(Representation representation) {

    }
}