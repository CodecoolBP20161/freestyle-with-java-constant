import javax.swing.*;
import java.util.ArrayList;

public class Launcher {
    public static void main( String args[] ) throws Exception {
        ArrayList<Play> playList = Play.selectAll();
        TableFromPostgreSQLDatabase frame = new TableFromPostgreSQLDatabase();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Constant");
        frame.pack();
        frame.setVisible(true);

    }
}