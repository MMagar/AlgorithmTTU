package maze;

import java.io.IOException;
import java.util.ArrayList;

public class Assignments {
    private MazeFileUtil fileUtil;
    private Maze solver;
    private char[][] maze;

    public Assignments(MazeFileUtil fileUtil) {
        this.fileUtil = fileUtil;
        solver = new Maze();
    }

    public void solve(String fileName) throws IOException {
        fileUtil.setFileName(fileName);
        fileUtil.readInput();
        solver.setDimension(fileUtil.getDimension());
        maze = fileUtil.getMaze();
        solver.solve(maze);
        fileUtil.writeResultsToFile(maze);
    }
}
