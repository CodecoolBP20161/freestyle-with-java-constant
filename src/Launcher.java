import java.util.ArrayList;

public class Launcher {
    public static void main( String args[] )
    {
        ArrayList<Play> playList = Play.selectAll();
        for (Play p: playList)
            System.out.println(p.time);

    }
}