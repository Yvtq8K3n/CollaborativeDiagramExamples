package collaborative.diagram.examples;

import collaborative.diagram.DiagramPanel;
import collaborative.diagram.DiagramServer;

import javax.swing.*;
import java.awt.*;
import java.net.URISyntaxException;

public class ServerReceiverDemo {
    public static void main(String[] args) throws URISyntaxException {
        DiagramServer.SERVER.createConnection("http://localhost", 9000, "Johnny Marquez");
        DiagramPanel panel = new DiagramPanel();

        //Creating and showing the main frame:
        final JFrame frame = new JFrame(ServerReceiverDemo.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //The size of the content pane adds some extra room for moving the labels:
        frame.setPreferredSize(new Dimension(500, 500));
        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
