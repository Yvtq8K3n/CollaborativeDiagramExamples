import collaborative.diagram.DiagramPanel;

import javax.swing.*;
import java.net.URISyntaxException;
import static collaborative.diagram.DiagramServer.SERVER;

public class ServerReceiverDemo {

    public static void main(String[] args) throws URISyntaxException {
        SERVER.createConnection("http://localhost", 9000, "Johnny Marquez");
        DiagramPanel panel = new DiagramPanel();

        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.add(panel);
    }
}
