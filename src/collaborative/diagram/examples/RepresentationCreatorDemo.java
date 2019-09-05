package collaborative.diagram.examples;

import collaborative.diagram.DiagramPanel;
import collaborative.diagram.DiagramServer;
import collaborative.diagram.element.*;
import collaborative.diagram.element.Polygon;
import collaborative.diagram.representation.Representation;
import org.json.JSONException;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.net.URISyntaxException;

public class RepresentationCreatorDemo {
    public static void main(String[] args) throws JSONException, URISyntaxException, IllegalAccessException {
        //Dar throw de erro se objecto ja existir no cliente

        //Initial Setup
        DiagramServer.SERVER.createConnection("http://localhost", 9000, "Johnny Marquez");
        DiagramPanel panel = new DiagramPanel();

        //Create element and add it to server
        Element rectangle = new Polygon.Rectangle("rectangle", 0.8f);
        DiagramServer.addElement(rectangle);

        //Create representations
        Representation repGradientPaint = createElementWithGradientPaint("GradientPaint", rectangle);
        DiagramServer.addRepresentation(repGradientPaint);

        Representation repLinearGradientPaint = createElementWithLinearGradientPaint("LinearGradientPaint", rectangle);
        DiagramServer.addRepresentation(repLinearGradientPaint);

        Representation repRadialGradientPaint = createElementWithRadialGradientPaint("RadialGradientPaint", rectangle);
        DiagramServer.addRepresentation(repRadialGradientPaint);

        Representation repStroke = createElementWithStroke("Stroke", rectangle);
        DiagramServer.addRepresentation(repStroke);

        //Creating and showing the main frame:
        final JFrame frame = new JFrame(RepresentationCreatorDemo.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //The size of the content pane adds some extra room for moving the labels:
        final Dimension paneSize = new Dimension(500, 500);
        frame.getContentPane().setPreferredSize(paneSize);
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static Representation createElementWithGradientPaint(String name, Element element) throws JSONException {
        Representation representation = new Representation(name, element, 100, 100, 100, 100);
        GradientPaint color =
                new GradientPaint(new Point2D.Float(0, 0), Color.BLACK,
                        new Point2D.Float(50, 50), Color.gray,true);
        representation.setColor(color);
        representation.setBackground(Color.RED);
        representation.setText(name);
        return representation;
    }

    public static Representation createElementWithLinearGradientPaint(String name, Element element) throws JSONException {
        Representation representation = new Representation(name, element,250, 100, 100, 100);
        LinearGradientPaint color =
                new LinearGradientPaint(new Point2D.Float(0, 0), new Point2D.Float(50, 50),
                        new float[]{0.0f, 0.2f, 1.0f}, new Color[]{Color.BLACK, Color.gray, Color.gray},
                        MultipleGradientPaint.CycleMethod.REPEAT);
        representation.setColor(Color.RED);
        representation.setBackground(color);
        representation.setText(name);
        return representation;
    }

    public static Representation createElementWithRadialGradientPaint(String name, Element element) throws JSONException {
        Representation representation = new Representation(name, element, 100, 250, 100, 100);
        RadialGradientPaint color =
                new RadialGradientPaint(new Point2D.Float(50, 50), 25, new Point2D.Float(40, 40),
                        new float[]{0.0f, 0.2f, 1.0f}, new Color[]{Color.BLACK, Color.gray, Color.gray},
                        MultipleGradientPaint.CycleMethod.REPEAT);
        representation.setColor(color);
        representation.setBackground(color);
        representation.setText(name);
        return representation;
    }

    public static Representation createElementWithStroke(String name, Element element) throws JSONException {
        Representation representation = new Representation(name, element, 250, 250, 100, 100);

        //Add stroke and strokeColor
        final float dash1[] = {10.0f};
        final BasicStroke dashed =
                new BasicStroke(4.0f,
                        BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER,
                        10.0f, dash1, 0.0f);
        representation.setStroke(dashed);
        representation.setStrokeColor(Color.GREEN);
        return representation;
    }
}
