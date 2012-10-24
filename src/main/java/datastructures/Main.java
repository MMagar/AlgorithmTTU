package datastructures;

import util.FileUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil("src/main/java/datastructures/", "input.in");
        DataStructureAssignments assignments = new DataStructureAssignments(fileUtil);
        try {
            assignments.readInput();
            assignments.processNumbers();
        } catch (IOException e) {
            System.out.println("Error while reading file. " + e);
        }

        try {
            assignments.saveResults();
        } catch (IOException e) {
            System.out.println("Error saving file. " + e);
        }
    }
}
