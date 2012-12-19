package util;

import datastructures.ComparableObjectHeap;
import knapsack.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ItemFileUtil {
    private String path;
    private String fileIn;
    private String fileOut;
    private int maxWeight;
    private Item[] items;

    public ItemFileUtil() {
        this("", "");
    }

    public ItemFileUtil(String path, String fileIn) {
        this.path = path;
        this.fileIn = fileIn;
    }

    public ItemFileUtil(String path) {
        this.path = path;
    }

    public void readInput() throws IOException {
        BufferedReader reader = initReader();
        maxWeight = Integer.parseInt(reader.readLine());
        items = readAndSortItemsBasedOnValue(reader);
    }

    BufferedReader initReader() throws FileNotFoundException {
        BufferedReader reader = null;
        String fullFilePath = path + "/input/" + fileIn;
        try {
            reader = new BufferedReader(new FileReader(fullFilePath));
        } catch (FileNotFoundException ignored) {
            System.out.println("File not found: " + fullFilePath);
            System.out.println("Looking from root");
        }
        if (reader == null) {
            reader = new BufferedReader(new FileReader(fileIn));
            path = "";
        }
        return reader;
    }

    Item[] readAndSortItemsBasedOnValue(BufferedReader reader) throws IOException {
        String line;
        ComparableObjectHeap<Item> heap = new ComparableObjectHeap<Item>();
        ArrayList<Item> items = new ArrayList<Item>();
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            int price = Integer.parseInt(parts[0]);
            int weight = Integer.parseInt(parts[1]);
            items.add(new Item(price, weight));
        }
        Collections.sort(items);
        Collections.reverse(items);
        Item[] result = new Item[items.size()];
        System.out.println("finished reading file and sorting.");
        for (Item item : items) {
            System.out.println(item.toString());
        }
        return items.toArray(result);
    }

    public void writeResultsToFile(int totalPrice, int totalWeight, Item[] items) throws IOException {
        FileWriter fileWriter = new FileWriter(path + "/output/" + fileOut);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.write(totalPrice + " " + totalWeight + "\n");
        for (Item item : items) {
            if (item != null)
                writer.write(item.getPrice() + " " + item.getWeight() + "\n");
        }
        writer.close();
        System.out.println("Results saved to file: " + fileOut);
    }

    public Item[] toReverseArray(ComparableObjectHeap<Item> heap) {
        Item[] result = new Item[heap.getSize()];
        for (int i = heap.getSize() - 1; i >= 0; i--) {
            result[i] = heap.dequeue();
        }
        return result;
    }

    public String getFileIn() {
        return fileIn;
    }

    public void setFileName(String name) {
        setFileIn(name + ".in");
        setFileOut(name + ".out");
    }

    public void setFileIn(String fileIn) {
        this.fileIn = fileIn;
    }

    public void setFileOut(String fileOut) {
        this.fileOut = fileOut;
    }

    public File getFileOut() {
        return new File(path + "/output/" + fileOut);
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public Item[] getItems() {
        return items;
    }
}
