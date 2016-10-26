/**
 * Created by vbenedek on 2016.10.26..
 */
public class Build {
    public static void main( String args[] ) {
        Play.dropPlayTable();
        Play.buildPlayTable();
        Play a = new Play(1, "oct. 26. 19:00", "János Vitéz", "Thália Színház");
        Play b = new Play(2, "oct. 26. 19:00", "A férfiagy - avagy nincs itt valami ellentmondás?", "Thália Színház");
        Play h = new Play(9, "oct. 1. 19:00", "Random mű", "Thália színház");
        Play i = new Play(10, "jun. 1. 19:00", "Random mű2", "Thália színház");
        a.insertToTable();
        b.insertToTable();
        h.insertToTable();
        i.insertToTable();
    }
}
