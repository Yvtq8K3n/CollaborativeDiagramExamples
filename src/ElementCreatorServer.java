import collaborative.diagram.*;
import collaborative.diagram.Element.Ellipse;
import collaborative.diagram.Element.Line;
import collaborative.diagram.Element.Polygon;
import org.json.JSONException;

import java.awt.geom.Point2D;
import java.net.URISyntaxException;

import static collaborative.diagram.DiagramServer.SERVER;

public class ElementCreatorServer {
    public static void main(String[] args) throws IllegalAccessException, JSONException, URISyntaxException {
        SERVER.createConnection("http://localhost", 8080, "Johnny Marquez");

        //Line
        SERVER.addElement(new Line("line", new Point2D.Double(0, 0.5), new Point2D.Double(1, 0.5)));
        SERVER.addElement(new Line.QuadraticCurve("qcurve", new Point2D.Double(0,0.5), new Point2D.Double(1, 0.5) , new Point2D.Double(1, 0.5)));
        SERVER.addElement(new Line.CubicCurve("ccurve", new Point2D.Double(0,0.5), new Point2D.Double(1, 0.5), new Point2D.Double(0.7, 0.8), new Point2D.Double(1, 0.5)));

        //Ellipse
        SERVER.addElement(new Ellipse("ellipse1", new Point2D.Double(0.5, 0.0), new Point2D.Double(0.0, 0.4)));
        SERVER.addElement(new Ellipse("ellipse2",0.3, 0.2));
        SERVER.addElement(new Ellipse.Circle("circle1", 0.4));

        //Polygon
        SERVER.addElement(new Polygon("polygon", new Point2D.Double(0.4, 0.3), new Point2D.Double(0.2, 0.3), new Point2D.Double(0.1, 0.2), new Point2D.Double(0.4, 0.8)));
        SERVER.addElement(Polygon.generateRegularPolygon("polygon",6, 0));

        SERVER.addElement(new Polygon.Triangle.Equilateral("tEqui",new Point2D.Double(0.5, 0.5)));
        SERVER.addElement(new Polygon.Triangle.Equilateral("tequ2",1));
        SERVER.addElement(new Polygon.Triangle.Isosceles("tIsoceles1", new Point2D.Double(0.5, 0.8), new Point2D.Double(0.5,0.2), 0.3f));
        SERVER.addElement(new Polygon.Triangle.Scalene("tScalene"));
        SERVER.addElement(new Polygon.Triangle.Scalene("tScalene"));
        SERVER.addElement(new Polygon.Rectangle("rec1", new Point2D.Double(0.2, 0.2), new Point2D.Double(0.8, 0.8)));
        SERVER.addElement(new Polygon.Rectangle("rec2", 0.6f, 0.6f));
        SERVER.addElement(new Polygon.Rectangle("Rec",0.8f));

    }
}
