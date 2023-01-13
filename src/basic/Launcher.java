package basic;

import java.io.IOException;
import java.sql.SQLException;

public class Launcher {
    public static void main(String[] args) throws IOException, InterruptedException, SQLException, ClassNotFoundException {
        Adventurer adventurer=new Adventurer();
        adventurer.start();
    }
}
