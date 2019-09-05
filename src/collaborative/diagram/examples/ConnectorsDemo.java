package collaborative.diagram.examples;

import collaborative.diagram.connector.Connector;
import collaborative.diagram.element.*;
import collaborative.diagram.element.Polygon;
import collaborative.diagram.representation.*;
import org.json.JSONException;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.net.URISyntaxException;

import static collaborative.diagram.DiagramServer.SERVER;

public class ConnectorsDemo {

    static Element circle;
    static Element rectangle;
    static Element irregularPolygon;

    public static void main(String[] args) throws JSONException, URISyntaxException {
        //Element
        circle = new Ellipse.Circle("circle", 0.4);
        rectangle = new Polygon.Rectangle("rectangle", 0.8f);
        irregularPolygon = new Polygon("irregularPolygon", new Point2D.Double(0.1, 0.1), new Point2D.Double(0.8, 0.8),
                new Point2D.Double(0.8, 0.1), new Point2D.Double(0.1, 0.8));

        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(elementsUsedExample());
        panel.add(connectorsExample());
        panel.add(connectorsTypeExample());

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.add(panel);
        frame.pack();
    }

    public static JPanel elementsUsedExample() throws JSONException {
        JLabel label = new JLabel("Elements Used");

        //Representation
        Representation repCircle =  new Representation("repCircle", circle);
        Representation repRectangle= new Representation("repRectangle", rectangle);
        Representation repTriangle = new Representation("repTriangle", irregularPolygon);

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(100, 25));
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(label);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.LINE_AXIS));
        centerPanel.setPreferredSize(new Dimension(310, 100));
        centerPanel.add(repCircle);
        centerPanel.add(repRectangle);
        centerPanel.add(repTriangle);

        JPanel border = new JPanel();
        border.setLayout(new BorderLayout());
        border.add(northPanel, BorderLayout.PAGE_START);
        border.add(centerPanel, BorderLayout.CENTER);

        return border;
    }

    public static JPanel connectorsExample() throws JSONException {
        JLabel label = new JLabel("Connectors Example");

        //Representation
        Representation repCircle =  new Representation("repCircle", circle);
        repCircle.setState(Representation.State.ACTIVE);
        Representation repRectangle= new Representation("repRectangle", rectangle);
        repRectangle.setState(Representation.State.ACTIVE);
        Representation repTriangle = new Representation("irregularPolygon", irregularPolygon);
        repTriangle.setState(Representation.State.ACTIVE);

        //Connectors
        Ellipse.addConnectors(repCircle, Connector.TYPE.Default, 8);
        Polygon.addConnectors(repRectangle, Connector.TYPE.Default);
        Element.addConnector(repTriangle, Connector.TYPE.Default, new Point2D.Double(0.1, 0.1));

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(100, 25));
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(label);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.LINE_AXIS));
        centerPanel.setPreferredSize(new Dimension(310, 100));
        centerPanel.add(repCircle);
        centerPanel.add(repRectangle);
        centerPanel.add(repTriangle);

        JPanel border = new JPanel();
        border.setLayout(new BorderLayout());
        border.add(northPanel, BorderLayout.PAGE_START);
        border.add(centerPanel, BorderLayout.CENTER);

        return border;
    }

    public static JPanel connectorsTypeExample() throws JSONException {
        JLabel label = new JLabel("Connectors Type Example");

        //Representation
        Representation repRectangle1 =  new Representation("repRectangle1", rectangle);
        repRectangle1.setState(Representation.State.ACTIVE);
        Representation repRectangle2= new Representation("repRectangle2", rectangle);
        repRectangle2.setState(Representation.State.ACTIVE);
        Representation repRectangle3 = new Representation("repRectangle3", rectangle);
        repRectangle3.setState(Representation.State.ACTIVE);

        //Connectors
        Polygon.addConnectors(repRectangle1, Connector.TYPE.Outgoing);
        Polygon.addConnectors(repRectangle2, Connector.TYPE.Default);
        Polygon.addConnectors(repRectangle3, Connector.TYPE.Incoming);

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(100, 25));
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(label);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.LINE_AXIS));
        centerPanel.setPreferredSize(new Dimension(310, 100));
        centerPanel.add(repRectangle1);
        centerPanel.add(repRectangle2);
        centerPanel.add(repRectangle3);

        JPanel border = new JPanel();
        border.setLayout(new BorderLayout());
        border.add(northPanel, BorderLayout.PAGE_START);
        border.add(centerPanel, BorderLayout.CENTER);

        return border;
    }
}
