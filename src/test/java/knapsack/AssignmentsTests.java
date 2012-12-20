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
    public void test15() throws Exception {
        testWithInputFile("15");
    }

    @Test
    public void test40() throws Exception {
        testWithInputFile("40");
    }

    @Test
    public void test100() throws Exception {
        testWithInputFile("100");
    }

    @Test
    public void test1000a() throws Exception {
        testWithInputFile("1000a");
    }

    private void testWithInputFile(String fileName) throws IOException {
        fileUtil.setFileName(fileName);

        assignments.solve();

        compareExpectedWithActualOutput(fileName);
    }

    private void compareExpectedWithActualOutput(String fileName) throws IOException {
        File expectedFile = new File(path + "/expected/" + fileName + ".out");
        File actualFile = new File(path + "/output/" + fileName + ".out");
        assertEquals(FileUtils.readFileToString(expectedFile), FileUtils.readFileToString(actualFile));
    }
}
