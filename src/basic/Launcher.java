package basic;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        Adventurer adventurer=new Adventurer();
        adventurer.start();
    }
}
