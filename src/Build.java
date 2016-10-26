/**
 * Created by vbenedek on 2016.10.26..
 */
public class Build {
    public static void main( String args[] ) {
        Play.dropPlayTable();
        Play.buildPlayTable();
        Play a = new Play(1, "1540", "Egy", "Moni");
        Play b = new Play(2, "1530", "Ketto", "Moni");
        Play c = new Play(3, "1530", "Harom", "Moni");
        a.insertToTable();
        b.insertToTable();
        c.insertToTable();
    }
}
