package maze;

public class Maze {
    private Location beginning;
    private Location finish;
    private char[][] maze;
    private int dimension;

    public char[][] solve(char[][] maze) {
        this.maze = maze;
        findBeginningAndFinishLocation();
        startFindingPath();
        return maze;
    }

    void findBeginningAndFinishLocation() {
        char character;
        beginning = null;
        finish = null;
        for (int column = 0; column < dimension; column++) {
            for (int row = 0; row < dimension; row++) {
                character = valueAtLocation(column, row);
                if (character == 'B') {
                    beginning = new Location(column, row);
                    if (finish != null) return;
                } else if (character == 'F') {
                    finish = new Location(column, row);
                    if (beginning != null) return;
                }
            }
        }
    }

    char valueAtLocation(int column, int row) {
        return maze[column * 2 + 1][row * 2 + 1];
    }

    private void startFindingPath() {

    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    void setMaze(char[][] maze) {
        this.maze = maze;
    }

    public Location getBeginning() {
        return beginning;
    }

    public Location getFinish() {
        return finish;
    }
}
