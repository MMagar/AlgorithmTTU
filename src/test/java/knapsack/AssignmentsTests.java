package knapsack;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import util.ItemFileUtil;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AssignmentsTests {
    ItemFileUtil fileUtil;
    Assignments assignments;
    String path = "src/test/java/knapsack";

    @Before
    public void setUp() throws Exception {
        fileUtil = new ItemFileUtil(path);
        assignments = new Assignments(fileUtil);
    }

    @Test
    public void test100() throws Exception {
        fileUtil.setFileName("15");

        assignments.solve();

        compareExpectedWithActualOutput("15");
    }

    private void compareExpectedWithActualOutput(String fileName) throws IOException {
        File expectedFile = new File(path + "/expected/" + fileName + ".out");
        File actualFile = new File(path + "/output/" + fileName + ".out");
        assertEquals(FileUtils.readFileToString(expectedFile), FileUtils.readFileToString(actualFile));
    }
}
