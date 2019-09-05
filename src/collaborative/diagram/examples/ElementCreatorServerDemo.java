package collaborative.diagram.examples;

import collaborative.diagram.element.*;
import org.json.JSONException;

import java.awt.geom.Point2D;
import java.net.URISyntaxException;

import static collaborative.diagram.DiagramServer.SERVER;

public class ElementCreatorServerDemo {
    public static void main(String[] args) throws IllegalAccessException, JSONException, URISyntaxException {
        SERVER.createConnection("http://localhost", 9000, "Johnny Marquez");

        //Line
        SERVER.addElement(new Line("line", new Point2D.Double(0, 0.5), new Point2D.Double(1, 0.5)));
        SERVER.addElement(new Line("line", new Point2D.Double(0, 0.5), new Point2D.Double(1, 0.5)));

        SERVER.addElement(new Line.QuadraticCurve("quadraticCurve", new Point2D.Double(0,1), new Point2D.Double(0, 0) , new Point2D.Double(1, 0)));
        SERVER.addElement(new Line.CubicCurve("cubicCurve", new Point2D.Double(0,1), new Point2D.Double(0, 0.5), new Point2D.Double(1, 0.5), new Point2D.Double(1, 0)));

        //Ellipse
        SERVER.addElement(new Ellipse("ellipse",0.5, 0.2));
        SERVER.addElement(new Ellipse("ellipse", new Point2D.Double(0.5, 0.0), new Point2D.Double(0.0, 0.4)));
        SERVER.addElement(new Ellipse.Circle("circle", 0.4));

        //Polygon
        SERVER.addElement(new Polygon("polygon", new Point2D.Double(0.4, 0.3), new Point2D.Double(0.2, 0.3), new Point2D.Double(0.1, 0.2), new Point2D.Double(0.4, 0.8)));
        SERVER.addElement(Polygon.generateRegularPolygon("hexagon",6, 0));

        SERVER.addElement(new Polygon.Triangle.Equilateral("equilateral",0.8));
        SERVER.addElement(new Polygon.Triangle.Equilateral("equilateral",new Point2D.Double(1, 0.5)));
        SERVER.addElement(new Polygon.Triangle.Isosceles("isosceles", new Point2D.Double(0.5, 0.8), new Point2D.Double(0.5,0.2), 0.3f));
        SERVER.addElement(new Polygon.Triangle.Scalene("scalene"));
        SERVER.addElement(new Polygon.Rectangle("rectangle",0.8f));
        SERVER.addElement(new Polygon.Rectangle("rectangle", new Point2D.Double(0.2, 0.2), new Point2D.Double(0.8, 0.8)));
        SERVER.addElement(new Polygon.Rectangle("rectangle", 0.6f, 0.6f));
    }
}
