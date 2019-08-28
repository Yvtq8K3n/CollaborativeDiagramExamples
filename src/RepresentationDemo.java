import collaborative.diagram.Element.Element;
import collaborative.diagram.Element.Polygon;
import collaborative.diagram.Representation.Representation;
import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class RepresentationDemo {

    static Element rectangle;//Element used
    static Paint paint1, paint2, paint3;

    public static void main(String[] args) throws JSONException {
        //Create Element
        rectangle = new Polygon.Rectangle("rectangle", 0.8);
        paint1 = Color.RED;
        paint2 = new LinearGradientPaint(new Point2D.Float(0, 0), new Point2D.Float(50, 50),
                new float[]{0.0f, 0.2f, 1.0f}, new Color[]{Color.BLACK, Color.gray, Color.gray},
                MultipleGradientPaint.CycleMethod.REPEAT);
        paint3 = new RadialGradientPaint(new Point2D.Float(50, 50), 25, new Point2D.Float(40, 40),
                new float[]{0.0f, 0.2f, 1.0f}, new Color[]{Color.RED, Color.GREEN, Color.BLUE},
                MultipleGradientPaint.CycleMethod.REPEAT);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(repStrokeExamples());
        panel.add(repStrokeColorExamples());
        panel.add(repColorExamples());
        panel.add(repBackgroundExamples());
        panel.add(repTextExamples());
        panel.add(repForegroundExamples());


        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.add(panel);
        frame.pack();
    }

    public static JPanel repStrokeExamples() throws JSONException {
        JLabel label = new JLabel("Stroke Example");

        //Create Representation whit Stroke Examples
        Representation repStroke1 = new Representation("repStroke1", rectangle);
        repStroke1.setStroke(new BasicStroke(2));

        Representation repStroke2 = new Representation("repStroke2", rectangle,
                new Point2D.Float( 100, 0), new Point2D.Float(100, 100));
        repStroke2.setStroke( new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                10.0f, new float[]{10.0f}, 0.0f));

        Representation repStroke3 = new Representation("repColor3", rectangle,
                new Point2D.Float( 200, 0), new Point2D.Float(100, 100));
        repStroke3.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));


        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(100, 25));
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(label);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.LINE_AXIS));
        centerPanel.setPreferredSize(new Dimension(310, 100));
        centerPanel.add(repStroke1);
        centerPanel.add(repStroke2);
        centerPanel.add(repStroke3);

        JPanel border = new JPanel();
        border.setLayout(new BorderLayout());
        border.add(northPanel, BorderLayout.PAGE_START);
        border.add(centerPanel, BorderLayout.CENTER);

        return border;
    }

    public static JPanel repStrokeColorExamples() throws JSONException {
        JLabel label = new JLabel("Representation Stroke Color Example");

        //Create Representations whit Stroke Color Examples
        Representation repStrokeColor1 = new Representation("repStrokeColor1", rectangle,
                new Point2D.Float( 0, 125), new Point2D.Float(100, 100));
        repStrokeColor1.setStroke(new BasicStroke(3));
        repStrokeColor1.setStrokeColor(Color.RED);

        Representation repStrokeColor2 = new Representation("repStrokeColor2", rectangle,
                new Point2D.Float( 100, 125), new Point2D.Float(100, 100));
        repStrokeColor2.setStroke(new BasicStroke(3));
        repStrokeColor2.setStrokeColor(paint2);

        Representation repStrokeColor3 = new Representation("repStrokeColor3", rectangle,
                new Point2D.Float( 200, 125), new Point2D.Float(100, 100));
        repStrokeColor3.setStroke(new BasicStroke(3));
        repStrokeColor3.setStrokeColor(paint3);

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(100, 25));
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(label);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.LINE_AXIS));
        centerPanel.setPreferredSize(new Dimension(310, 100));
        centerPanel.add(repStrokeColor1);
        centerPanel.add(repStrokeColor2);
        centerPanel.add(repStrokeColor3);

        JPanel border = new JPanel();
        border.setLayout(new BorderLayout());
        border.add(northPanel, BorderLayout.PAGE_START);
        border.add(centerPanel, BorderLayout.CENTER);

        return border;
    }

    public static JPanel repColorExamples() throws JSONException {
        JLabel label = new JLabel("Representation Color Examples:");

        //Create Representation whit Stroke Color Examples
        Representation repColor1 = new Representation("repColor1", rectangle,
                new Point2D.Float( 0, 250), new Point2D.Float(100, 100));
        repColor1.setColor(Color.RED);

        Representation repColor2 = new Representation("repColor2", rectangle,
                new Point2D.Float( 100, 250), new Point2D.Float(100, 100));
        repColor2.setColor(paint2);

        Representation repColor3 = new Representation("repColor3", rectangle,
                new Point2D.Float( 200, 250), new Point2D.Float(100, 100));
        repColor3.setColor(paint3);

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(100, 25));
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(label);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.LINE_AXIS));
        centerPanel.setPreferredSize(new Dimension(310, 100));
        centerPanel.add(repColor1);
        centerPanel.add(repColor2);
        centerPanel.add(repColor3);

        JPanel border = new JPanel();
        border.setLayout(new BorderLayout());
        border.add(northPanel, BorderLayout.PAGE_START);
        border.add(centerPanel, BorderLayout.CENTER);

        return border;
    }

    public static JPanel repBackgroundExamples() throws JSONException {
        JLabel label = new JLabel("Representation Background Examples:");

        //Create Representation whit Background Examples
        Representation repBackground1 = new Representation("repBackground1", rectangle,
                new Point2D.Float( 0, 250), new Point2D.Float(100, 100));
        repBackground1.setBackground(paint1);

        Representation repBackground2 = new Representation("repBackground2", rectangle,
                new Point2D.Float( 100, 250), new Point2D.Float(100, 100));
        repBackground2.setBackground(paint2);

        Representation repBackground3 = new Representation("repBackground3", rectangle,
                new Point2D.Float( 200, 250), new Point2D.Float(100, 100));
        repBackground3.setBackground(paint3);

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(100, 25));
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(label);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.LINE_AXIS));
        centerPanel.setPreferredSize(new Dimension(310, 100));
        centerPanel.add(repBackground1);
        centerPanel.add(repBackground2);
        centerPanel.add(repBackground3);

        JPanel border = new JPanel();
        border.setLayout(new BorderLayout());
        border.add(northPanel, BorderLayout.PAGE_START);
        border.add(centerPanel, BorderLayout.CENTER);

        return border;
    }

    public static JPanel repTextExamples() throws JSONException {
        JLabel label = new JLabel("Representation Text Examples:");

        //Create Representation whit Text Examples
        Representation repText1 = new Representation("repText1", rectangle,
                new Point2D.Float( 0, 250), new Point2D.Float(100, 100));
        repText1.setText("repText1");

        Representation repText2 = new Representation("repText2", rectangle,
                new Point2D.Float( 100, 250), new Point2D.Float(100, 100));
        repText2.setText("repText2");

        Representation repText3 = new Representation("repText3", rectangle,
                new Point2D.Float( 200, 250), new Point2D.Float(100, 100));
        repText3.setText("repText3");

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(100, 25));
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(label);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.LINE_AXIS));
        centerPanel.setPreferredSize(new Dimension(310, 100));
        centerPanel.add(repText1);
        centerPanel.add(repText2);
        centerPanel.add(repText3);

        JPanel border = new JPanel();
        border.setLayout(new BorderLayout());
        border.add(northPanel, BorderLayout.PAGE_START);
        border.add(centerPanel, BorderLayout.CENTER);

        return border;
    }

    public static JPanel repForegroundExamples() throws JSONException {
        JLabel label = new JLabel("Representation Foreground Examples:");

        //Create Representation whit Foreground Examples
        Representation repText1 = new Representation("repText1", rectangle,
                new Point2D.Float( 0, 250), new Point2D.Float(100, 100));
        repText1.setText("repText1");
        repText1.setForeground(paint1);

        Representation repText2 = new Representation("repText2", rectangle,
                new Point2D.Float( 100, 250), new Point2D.Float(100, 100));
        repText2.setText("repText2");
        repText2.setForeground(paint2);

        Representation repText3 = new Representation("repText3", rectangle,
                new Point2D.Float( 200, 250), new Point2D.Float(100, 100));
        repText3.setText("repText3");
        repText3.setForeground(paint3);

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(100, 25));
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(label);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.LINE_AXIS));
        centerPanel.setPreferredSize(new Dimension(310, 100));
        centerPanel.add(repText1);
        centerPanel.add(repText2);
        centerPanel.add(repText3);

        JPanel border = new JPanel();
        border.setLayout(new BorderLayout());
        border.add(northPanel, BorderLayout.PAGE_START);
        border.add(centerPanel, BorderLayout.CENTER);

        return border;
    }
}
