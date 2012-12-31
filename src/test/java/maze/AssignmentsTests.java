package maze;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AssignmentsTests {
    Assignments assignments;
    String path = "src/test/java/maze";

    @Before
    public void setUp() throws Exception {
        MazeFileUtil fileUtil = new MazeFileUtil(path);
        assignments = new Assignments(fileUtil);
    }

    @Test
    public void testA5() throws Exception {
        assignments.solve("a5");

        compareExpectedWithActualOutput("a5");
    }

    @Test
    public void testA20() throws Exception {
        assignments.solve("a20");

        compareExpectedWithActualOutput("a20");
    }

    @Test
    public void testH10() throws Exception {
        assignments.solve("h10");

        compareExpectedWithActualOutput("h10");
    }

    private void compareExpectedWithActualOutput(String fileName) throws IOException {
        File expectedFile = new File(path + "/expected/" + fileName + ".out");
        File actualFile = new File(path + "/output/" + fileName + ".out");
        assertEquals(FileUtils.readFileToString(expectedFile), FileUtils.readFileToString(actualFile));
    }
}
