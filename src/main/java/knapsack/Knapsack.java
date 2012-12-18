package knapsack;

public class Knapsack {
    int maxWeight;
    Item[] items;

    public Knapsack(int maxWeight, Item... items) {
        this.maxWeight = maxWeight;
        this.items = items;
    }

    public int getTotalWeight() {
        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public boolean isOverWeightLimit() {
        return getTotalWeight() > maxWeight;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}
