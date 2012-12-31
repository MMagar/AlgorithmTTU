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
    public void testMazesOfTypeA() throws Exception {
        testWithInput("a5");
        testWithInput("a7");
        testWithInput("a10");
        testWithInput("a15");
        testWithInput("a20");
        testWithInput("a30");
        testWithInput("a40");
        testWithInput("a50");
        testWithInput("a100");
        testWithInput("a200");
    }

    @Test
    public void testMazesOfTypeB() throws Exception {
        testWithInput("h10");
        testWithInput("h15");
        testWithInput("h20");
        testWithInput("h30");
        testWithInput("h40");
        testWithInput("h50");
        testWithInput("h100");
    }

    private void testWithInput(String fileName) throws IOException {
        assignments.solve(fileName);

        compareExpectedWithActualOutput(fileName);
    }

    private void compareExpectedWithActualOutput(String fileName) throws IOException {
        File expectedFile = new File(path + "/expected/" + fileName + ".out");
        File actualFile = new File(path + "/output/" + fileName + ".out");
        assertEquals(FileUtils.readFileToString(expectedFile), FileUtils.readFileToString(actualFile));
    }
}
