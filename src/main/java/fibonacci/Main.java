package fibonacci;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        System.out.println("jej");
        String path = "src/main/java/fibonacci/";
        BufferedReader reader;
        String line;
        ArrayList<Integer> inputNumbers = new ArrayList<Integer>();
        try {

            reader = new BufferedReader(new FileReader(path + "input.in"));
            while ((line = reader.readLine()) != null) {
                Integer number = Integer.parseInt(line);
                inputNumbers.add(number);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(inputNumbers.toArray()));

        try {
            FileWriter fileWriter = new FileWriter(path + "output.out");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("Hello Java");
            writer.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}

