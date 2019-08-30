import collaborative.diagram.DiagramPanel;
import collaborative.diagram.Element.Element;
import collaborative.diagram.Element.Ellipse;
import collaborative.diagram.Element.Line;
import collaborative.diagram.Element.Polygon;
import collaborative.diagram.Representation.Representation;
import collaborative.diagram.Selector.Selector;
import org.json.JSONException;

import javax.swing.*;
import java.awt.geom.Point2D;
import java.net.URISyntaxException;

import static collaborative.diagram.DiagramServer.SERVER;

public class SelectorsDemo {
    public static void main(String[] args) throws JSONException, URISyntaxException {
        SERVER.createConnection("http://localhost", 9000, "Johnny Marquez");

        Element rectangle = new Polygon.Rectangle("rectangle", 0.8);

        Representation repSelectorVertical = new Representation("reoCircle", rectangle,
                new Point2D.Float( 25, 25), new Point2D.Float(100, 100), Selector.Region.NORTHSOUTH);
        Representation repSelectorHorizontal = new Representation("repTriangle", rectangle,
                new Point2D.Float(125, 25), new Point2D.Float(100, 100), Selector.Region.WESTEAST);
        Representation repSelectorDiagonal = new Representation("repRectangle", rectangle,
                new Point2D.Float(225, 25), new Point2D.Float(100, 100), Selector.Region.CORNERS);

        Representation repSelector1 = new Representation("repSelector1", rectangle,
               25, 125,100, 100);
        Representation repSelector2 = new Representation("repSelector2", rectangle,
                new Point2D.Float(125, 125), new Point2D.Float(100, 100), false);
        Representation repSelector3 = new Representation("repSelector3", rectangle,
                new Point2D.Float(225, 125), new Point2D.Float(100, 100), Selector.Region.CORNERS, Selector.Region.WESTEAST, Selector.Region.WESTEAST,
                Selector.Region.NORTHSOUTH, Selector.Region.NORTHSOUTH);


        //Create DiagramPanel
        DiagramPanel panel = new DiagramPanel();
        panel.add(repSelectorVertical);
        panel.add(repSelectorHorizontal);
        panel.add(repSelectorDiagonal);

        panel.add(repSelector1);
        panel.add(repSelector2);
        panel.add(repSelector3);

        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.add(panel);
    }
}
