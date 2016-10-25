import java.sql.ResultSet;
import java.util.ArrayList;

public class Play {
    Integer id;
    String time, title, director;

    public Play(Integer id, String time, String title, String director){
        this.id = id;
        this.time = time;
        this.title = title;
        this.director = director;
    }

    public static ArrayList selectAll() {
        ArrayList<Play> playList = new ArrayList<Play>();
        try {
            PostgreSQLConnection database = new PostgreSQLConnection();
            database.setConnection();
            ResultSet rs = database.statement.executeQuery("SELECT * FROM play");

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String time = rs.getString("time");
                String title = rs.getString("title");
                String director = rs.getString("director");
                playList.add(new Play(id, time, title, director));
            }
            rs.close();
            database.closeConnection();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return playList;
    }

}

