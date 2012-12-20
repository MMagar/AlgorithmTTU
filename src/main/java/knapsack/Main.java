package knapsack;

import util.ItemFileUtil;

public class Main {

    public static void main(String[] args) {
        ItemFileUtil util = new ItemFileUtil("src/main/java/knapsack");
        util.setFileIn("15.in");
        util.setFileOut("15.out");
        Assignments assignments = new Assignments(util);
        assignments.solve();
    }
}
