package maze;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        MazeFileUtil util = new MazeFileUtil("src/main/java/maze");
        Assignments assignments = new Assignments(util);
        assignments.solve("a5");
    }
}
