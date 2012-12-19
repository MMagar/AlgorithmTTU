package knapsack;

import util.ItemFileUtil;

import java.io.IOException;

public class Assignments {
    ItemFileUtil fileUtil;
    KnapsackPacker packer;

    public Assignments(ItemFileUtil fileUtil) {
        this.fileUtil = fileUtil;
    }

    public void solve() {
        try {
            fileUtil.readInput();
            packer = new KnapsackPacker(fileUtil.getMaxWeight(), fileUtil.getItems());
            packer.solve();
            fileUtil.writeResultsToFile(packer.getBestFoundPrice(), packer.getBestFoundWeight(), packer.getBestItemSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
