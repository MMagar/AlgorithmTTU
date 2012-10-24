package util;

import java.io.*;
import java.util.ArrayList;

public class FileUtil {
    private String path;
    private String fileIn;

    public FileUtil(String path, String fileIn) {
        this.path = path;
        this.fileIn = fileIn;
    }

    public ArrayList<Integer> readInputNumbers() throws IOException {
        ArrayList<Integer> inputNumbers = new ArrayList<Integer>();
        String line;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path + fileIn));
        } catch (FileNotFoundException ignored) {}
        if(reader == null) {
            reader = new BufferedReader(new FileReader(fileIn));
            path = "";
        }

        while ((line = reader.readLine()) != null) {
            Integer number = Integer.parseInt(line);
            inputNumbers.add(number);
        }
        return inputNumbers;
    }

    public void writeResultsToFile(ArrayList<Integer> numbers, String fileOut) throws IOException {
        FileWriter fileWriter = new FileWriter(path + fileOut);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        for (Integer number : numbers) {
            writer.write(number + "\n");
        }
        writer.close();
        System.out.println("Results saved to file: " + fileOut);
    }

    public String getFileIn() {
        return fileIn;
    }

    public void setFileIn(String fileIn) {
        this.fileIn = fileIn;
    }

}
