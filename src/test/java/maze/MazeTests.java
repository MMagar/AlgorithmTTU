package maze;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MazeTests {
    Maze maze;
    MazeFileUtil util;

    @Before
    public void setUp() throws Exception {
        maze = new Maze();
        util = new MazeFileUtil("src/test/java/maze");
    }

    @Test
    public void testValueAtLocation() throws Exception {
        maze.setMaze(getSmallMaze());

        assertEquals(' ',maze.getValueAtLocation(0, 0));
        assertEquals('B',maze.getValueAtLocation(0, 4));
        assertEquals('F',maze.getValueAtLocation(4, 0));
    }

    @Test
    public void testBeginningAndFinish() throws Exception {
        maze.setMaze(getSmallMaze());
        maze.setDimension(5);

        maze.findBeginningAndFinishLocation();

        assertTrue(new Location(0,4).equals(maze.getBeginning()));
        assertTrue(new Location(4,0).equals(maze.getFinish()));
    }

    @Test
    public void pickShorterPath() throws Exception {
        ArrayList<Location> longerPath = new ArrayList<Location>();
        ArrayList<Location> shorterPath = new ArrayList<Location>();
        ArrayList<Location> invalidPath = null;
        longerPath.add(new Location(1, 1));
        longerPath.add(new Location(1, 2));
        shorterPath.add(new Location(1, 2));

        assertEquals(shorterPath, maze.pickShortestPath(longerPath, shorterPath, invalidPath));
    }

    @Test
    public void findPathToFinish() throws Exception {
        maze.setDimension(5);
        maze.solve(getSmallMaze());
        ArrayList<Location> path = maze.bestFoundPath;

        assertEquals(15, path.size());
    }

    private char[][] getSmallMaze() throws IOException {
        return readMazeFile("a5");
    }

    private char[][] getMediumMaze() throws IOException {
        return readMazeFile("a20");
    }

    private char[][] readMazeFile(String fileName) throws IOException {
        util.setFileName(fileName);
        util.readInput();
        return util.getMaze();
    }

}
