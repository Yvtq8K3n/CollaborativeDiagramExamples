package collaborative.diagram.examples;

import collaborative.diagram.DiagramPanel;
import collaborative.diagram.DiagramServer;
import collaborative.diagram.NetworkObserver;
import collaborative.diagram.element.Composed;
import collaborative.diagram.element.Element;
import collaborative.diagram.element.Ellipse;
import collaborative.diagram.element.Polygon;
import collaborative.diagram.representation.Representation;
import org.json.JSONException;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.Point2D;
import java.net.URISyntaxException;

import static collaborative.diagram.DiagramServer.SERVER;

public class ElementDisplayServerDemo implements NetworkObserver {
    private JPanel panel;

    public static void main(String[] args) throws URISyntaxException, JSONException {
        DiagramServer.SERVER.createConnection("http://localhost", 9000, "Johnny Marquez");
        new ElementDisplayServerDemo();
    }

    public ElementDisplayServerDemo() throws JSONException {
        panel = new JPanel(new GridLayout(3, 5));
        panel.setPreferredSize(new Dimension(400, 250));

        //Registers to get notified when new elements arrive
        SERVER.addNetworkObserver(this);

        JFrame frame = new JFrame(ElementDisplayServerDemo.class.getSimpleName());
        frame.setVisible(true);
        frame.add(panel);
        frame.pack();
    }

    @Override
    public void notifyElementCreation(Element element) {
        try {
            Representation rep = new Representation("rep", element);
            rep.setText(element.getName());
            rep.setPreferredSize(new Dimension(50,50));
            panel.add(rep);
            panel.revalidate();
            panel.repaint();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void notifyElementAlteration(Element element) {
        panel.revalidate();
        panel.repaint();
    }

    @Override
    public void notifyRepresentationCreation(Representation representation) {

    }

    @Override
    public void notifyRepresentationAlteration(Representation representation) {

    }
}