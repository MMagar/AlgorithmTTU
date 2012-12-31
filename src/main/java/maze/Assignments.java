package maze;

import java.io.IOException;
import java.util.ArrayList;

public class Assignments {
    private MazeFileUtil fileUtil;
    private Maze solver;
    private char[][] maze;
    public static final char WALKED_PATH_CHARACTER = '*';

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
        drawPathToMaze(solver.bestFoundPath);
        fileUtil.writeResultsToFile(maze);
    }

    private void drawPathToMaze(ArrayList<Location> path) {
        Location previous = path.remove(0);
        Location finish = path.remove(path.size() - 1);
        for (Location location : path) {
            setLocationAsWalkedPath(location);
            setAsWakedPathBetweenLocations(previous, location);
            previous = location;
        }
        setAsWakedPathBetweenLocations(previous, finish);
    }

    void setLocationAsWalkedPath(Location location) {
        setCoordinateAsWalked(location.getX(), location.getY());
    }

    void setAsWakedPathBetweenLocations(Location start, Location end) {
        if (start.getX() == end.getX()) {
            if (start.getY() < end.getY()) {
                setCoordinateAsWalked(start.getX(), start.getY() + 1);
            } else {
                setCoordinateAsWalked(start.getX(), start.getY() - 1);
            }
        } else {
            if (start.getX() < end.getX()) {
                setCoordinateAsWalked(start.getX() + 1, start.getY());
            } else {
                setCoordinateAsWalked(start.getX() - 1, start.getY());
            }
        }
    }

    private void setCoordinateAsWalked(int x, int y) {
        maze[x][y] = WALKED_PATH_CHARACTER;
    }
}
