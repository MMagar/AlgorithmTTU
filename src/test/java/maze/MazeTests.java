package maze;

import org.junit.Before;
import org.junit.Test;
import util.MazeFileUtil;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MazeTests {
    Maze maze;

    @Before
    public void setUp() throws Exception {
        maze = new Maze();
    }

    @Test
    public void testValueAtLocation() throws Exception {
        maze.setMaze(getSmallMaze());

        assertEquals(' ',maze.valueAtLocation(0,0));
        assertEquals('B',maze.valueAtLocation(0,4));
        assertEquals('F',maze.valueAtLocation(4,0));
    }

    @Test
    public void testBeginningAndFinish() throws Exception {
        maze.setMaze(getSmallMaze());
        maze.setDimension(5);

        maze.findBeginningAndFinishLocation();

        assertTrue(new Location(0,4).equals(maze.getBeginning()));
        assertTrue(new Location(4,0).equals(maze.getFinish()));
    }

    private char[][] getSmallMaze() throws IOException {
        return readMazeFile("a5");
    }

    private char[][] getMediumMaze() throws IOException {
        return readMazeFile("a20");
    }

    private char[][] readMazeFile(String fileName) throws IOException {
        MazeFileUtil util = new MazeFileUtil("src/test/java/maze");
        util.setFileName(fileName);
        util.readInput();
        return util.getMaze();
    }

}
