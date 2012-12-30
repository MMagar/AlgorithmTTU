package maze;

public class Intersection {
    private int x;
    private int y;
    private Integer tilesToBeginning = null;
    private Direction toBeginning = null;
    private Integer tilesToFinish = null;
    private Direction toFinish = null;
    private char[][] maze;

    public Intersection(int x, int y, char[][] maze) {
        this.x = x;
        this.y = y;
        this.maze = maze;
    }

    public boolean canGoUp() {
        return maze[x][y - 1] == ' ';
    }

    public boolean canGoDown() {
        return maze[x][y + 1] == ' ';
    }

    public boolean canGoLeft() {
        return maze[x - 1][y] == ' ';
    }

    public boolean canGoRight() {
        return maze[x + 1][y] == ' ';
    }

    public void connectTo(Intersection other, Direction towardsOther, int distance) {
        updatePathsToBeginning(other, towardsOther, distance);
    }

    private void updatePathsToBeginning(Intersection other, Direction towardsOther, int distance) {
        if (tilesToBeginning == null && other.getTilesToBeginning() != null) {
            setNewPathToBeginning(other.getTilesToBeginning() + distance, towardsOther);
        } else if (other.getTilesToBeginning() == null && tilesToBeginning != null) {
            other.setNewPathToBeginning(this.getTilesToBeginning() + distance, Direction.reverse(towardsOther));
        } else if (tilesToBeginning != null && other.getTilesToBeginning() != null) {
            comparePathsToBeginning(other, distance);
        }
    }

    private void comparePathsToBeginning(Intersection other, int distance) {
        if(tilesToBeginning < other.getTilesToBeginning() + distance) {

        } else if (tilesToBeginning > other.getTilesToBeginning()) {

        }
    }

    public void setNewPathToBeginning(int distance, Direction direction) {
        this.tilesToBeginning = distance;
        this.toBeginning = direction;
    }

    public Integer getTilesToFinish() {
        return tilesToFinish;
    }

    public void setTilesToFinish(Integer tilesToFinish) {
        this.tilesToFinish = tilesToFinish;
    }

    public Integer getTilesToBeginning() {
        return tilesToBeginning;
    }

    public void setTilesToBeginning(Integer tilesToBeginning) {
        this.tilesToBeginning = tilesToBeginning;
    }
}
