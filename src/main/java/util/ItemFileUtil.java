package util;

import datastructures.ComparableObjectHeap;
import knapsack.Item;

import java.io.*;
import java.util.ArrayList;

public class ItemFileUtil {
    private String path;
    private String fileIn;
    private int maxWeight;
    private Item[] items;

    public ItemFileUtil() {
        this("","");
    }

    public ItemFileUtil(String path, String fileIn) {
        this.path = path;
        this.fileIn = fileIn;
    }

    public void readInput() throws IOException {
        BufferedReader reader = initReader();
        maxWeight = Integer.parseInt(reader.readLine());
        items = readAndSortItemsBasedOnValue(reader);
    }

    BufferedReader initReader() throws FileNotFoundException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path + fileIn));
        } catch (FileNotFoundException ignored) {
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
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            int price = Integer.parseInt(parts[0]);
            int weight = Integer.parseInt(parts[1]);
            heap.enqueue(new Item(price, weight));
        }
        return toReverseArray(heap);
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

    public void setFileIn(String fileIn) {
        this.fileIn = fileIn;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public Item[] getItems() {
        return items;
    }
}
