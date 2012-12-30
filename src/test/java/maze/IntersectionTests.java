package maze;

import org.junit.Test;
import util.MazeFileUtil;

import java.io.IOException;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntersectionTests {

    @Test
    public void testAvailableDirectionsOfIntersections() throws Exception {
        char [][] maze = getSmallMaze();
        Intersection intersection = new Intersection(1,1, maze);

        assertTrue(intersection.canGoRight());
        assertTrue(intersection.canGoDown());
        assertFalse(intersection.canGoUp());
        assertFalse(intersection.canGoLeft());
    }

    private char[][] getSmallMaze() throws IOException {
        return readMazeFile("a5");
    }

    private char[][] readMazeFile(String fileName) throws IOException {
        MazeFileUtil util = new MazeFileUtil("src/test/java/maze");
        util.setFileName(fileName);
        util.readInput();
        return util.getMaze();
    }
}
