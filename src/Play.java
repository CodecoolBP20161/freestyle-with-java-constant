import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Play {
    Integer id;
    String time, title, place;

    public Play(Integer id, String time, String title, String place){
        this.id = id;
        this.time = time;
        this.title = title;
        this.place = place;
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
                String place = rs.getString("place");
                playList.add(new Play(id, time, title, place));
            }
            rs.close();
            database.closeConnection();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return playList;
    }

    public static void buildPlayTable() {
        PostgreSQLConnection database = new PostgreSQLConnection();
        try {
            database.setConnection();
            String sql = "CREATE TABLE IF NOT EXISTS play " +
                "(id SERIAL PRIMARY KEY, " +
                " time VARCHAR(100), " +
                " title VARCHAR(100), " +
                " place VARCHAR(100))";
            database.statement.executeUpdate(sql);
            database.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropPlayTable() {
        PostgreSQLConnection database = new PostgreSQLConnection();
        try {
            database.setConnection();
            String sql = "DROP TABLE IF EXISTS play";
            database.statement.executeUpdate(sql);
            database.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertToTable() {
        PostgreSQLConnection database = new PostgreSQLConnection();
        try {
            database.setConnection();
            String sql = String.format("INSERT INTO play (time, title, place) VALUES ('%s','%s','%s')", time, title, place);
            database.statement.executeUpdate(sql);
            database.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

