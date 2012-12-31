package maze;

import java.io.*;

public class MazeFileUtil {
    private String path;
    private String fileName;
    private int dimension;
    private char[][] maze;

    public MazeFileUtil(String path) {
        this.path = path;
    }

    public void readInput() throws IOException {
        BufferedReader reader = initReader();
        dimension = Integer.parseInt(reader.readLine());
        maze = readMaze(reader);
    }

    BufferedReader initReader() throws FileNotFoundException {
        BufferedReader reader = null;
        String fullFilePath = path + "/input/" + fileName + ".in";
        try {
            reader = new BufferedReader(new FileReader(fullFilePath));
        } catch (FileNotFoundException ignored) {
            System.out.println("File not found: " + fullFilePath);
            System.out.println("Looking from root");
        }
        if (reader == null) {
            reader = new BufferedReader(new FileReader(fileName));
            path = "";
        }
        return reader;
    }

    char[][] readMaze(BufferedReader reader) throws IOException {
        int characterInt;
        int size = 2 * dimension + 1;
        char[][] maze = new char[size][size];
        int row = 0;
        int column = 0;
        while ((characterInt = reader.read()) != -1) {
            char character = (char) characterInt;
            if (character == '\n') {
                row++;
                column = 0;
            } else if (character == '\r') {
                //ignore
            } else {
                maze[column][row] = character;
                column++;
            }
        }
        return maze;
    }

    public void writeResultsToFile(char maze[][]) throws IOException {
        FileWriter fileWriter = new FileWriter(path + "/output/" + fileName + ".out");
        BufferedWriter writer = new BufferedWriter(fileWriter);
        for (int row = 0; row< dimension * 2 + 1; row++) {
            for (int column = 0; column < dimension * 2 + 1; column++) {
                writer.write(maze[column][row]);
            }
            writer.write("\n");
        }
        writer.write("\n");
        writer.close();
        System.out.println("Results saved to file: " + fileName + ".out");
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public char[][] getMaze() {
        return maze;
    }

    public int getDimension() {
        return dimension;
    }
}
