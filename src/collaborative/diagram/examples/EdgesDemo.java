package collaborative.diagram.examples;

import collaborative.diagram.connector.Connector;
import collaborative.diagram.DiagramPanel;
import collaborative.diagram.edge.Edge;
import collaborative.diagram.element.Element;
import collaborative.diagram.element.Ellipse;
import collaborative.diagram.element.Line;
import collaborative.diagram.element.Polygon;
import collaborative.diagram.representation.Representation;
import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.net.URISyntaxException;

import static collaborative.diagram.DiagramServer.SERVER;

public class EdgesDemo {

    public static void main(String[] args) throws JSONException, URISyntaxException {
        SERVER.createConnection("http://3.8.175.171", 9000, "Johnny Marquez");
        DiagramPanel panel = new DiagramPanel();

        //Element
        Element circle = new Ellipse.Circle("circle", 0.4);
        Element rectangle = new Polygon.Rectangle("rectangle", 0.8f);
        Element triangle = new Polygon.Triangle.Isosceles("triangle",
                new Point2D.Double(0.1, 0.1), new Point2D.Double(0.1, 0.9), 0.9f);

        //Representation
        Representation repStart = circleStart("Start", circle);
        Representation repEnd = circleEnd("End", circle);
        Representation repActivity = rectangle("Comprar Casa", rectangle);

        Edge edgeAct1 = new Edge(line(""), triangle, Element.class, Element.class);

        JButton btnOperatorEdge = new JButton("Create Connection");
        btnOperatorEdge.setLocation(0, 0);
        btnOperatorEdge.setSize(150, 25);
        btnOperatorEdge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setEdgeOperator(edgeAct1);
            }
        });
        panel.add(btnOperatorEdge);
        panel.add(repStart);
        panel.add(repActivity);
        panel.add(repEnd);


        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.add(panel);
    }

    public static Representation rectangle(String name, Element element) throws JSONException {
        Representation repActivity = new Representation(name, element, 220, 300, 150, 105);
        repActivity.setText(name);
        Polygon.Rectangle.addConnectors(repActivity, Connector.TYPE.Default);

        return repActivity;
    }

    public static Representation circleStart(String name, Element element) throws JSONException {
        Representation rep = new Representation(name, element, 20, 100, 100, 100);
        rep.setColor(Color.WHITE);
        rep.setStrokeColor(Color.GREEN);
        rep.setText(name);
        Ellipse.Circle.addConnectors(rep, Connector.TYPE.Default, 6);
        return rep;
    }

    public static Representation circleEnd(String name, Element element) throws JSONException {
        Representation rep = new Representation(name, element, 330, 100, 100, 100);
        rep.setColor(Color.WHITE);
        rep.setStrokeColor(Color.RED);
        rep.setText(name);
        Ellipse.Circle.addConnectors(rep, Connector.TYPE.Default, 6);
        return rep;
    }

    public static Line line(String name) throws JSONException {
        Line line = new Line(name, new Point2D.Double(0,0), new Point2D.Double(1,0));
        //line.setText(name);
        //line.setColor(Color.BLACK);
        return line;
    }
}
