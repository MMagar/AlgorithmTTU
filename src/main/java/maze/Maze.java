package maze;

import java.util.ArrayList;

public class Maze {
    public static final char WALL = 'X';
    public static final char PATH_TO_FINISH = '*';
    public static final char BEGINNING = 'B';
    public static final char FINISH = 'F';
    private Location beginning;
    private Location finish;
    private char[][] maze;
    private int dimension;
    ArrayList<Location> bestFoundPath;

    public char[][] solve(char[][] maze) {
        bestFoundPath = null;
        this.maze = maze;
        findBeginningAndFinishLocations();
        findShortestPathFromBeginningToFinish();
        drawBestPathToMaze();
        return maze;
    }

    void findBeginningAndFinishLocations() {
        char character;
        beginning = null;
        finish = null;
        for (int column = 0; column < dimension; column++) {
            for (int row = 0; row < dimension; row++) {
                character = getValueAtLocation(column, row);
                if (character == BEGINNING) {
                    beginning = new Location(column, row);
                    if (finish != null) return;
                } else if (character == FINISH) {
                    finish = new Location(column, row);
                    if (beginning != null) return;
                }
            }
        }
    }

    char getValueAtLocation(int column, int row) {
        return maze[column * 2 + 1][row * 2 + 1];
    }

    private void findShortestPathFromBeginningToFinish() {
        ArrayList<Location> path = new ArrayList<Location>();
        path.add(beginning);
        findFinish(beginning, path);
    }

    private void findFinish(Location location, ArrayList<Location> passedLocations) {
        if (isFinish(location)) {
            bestFoundPath = passedLocations;
        }
        if(!isLongerThanCurrentBestFoundPath(passedLocations))
            findFinishByLookingAtAllDirections(location, passedLocations);
    }

    private boolean isFinish(Location location) {
        return finish.equals(location);
    }

    private boolean isLongerThanCurrentBestFoundPath(ArrayList<Location> currentPath) {
        return bestFoundPath != null && bestFoundPath.size() < currentPath.size();
    }

    private void findFinishByLookingAtAllDirections(Location location, ArrayList<Location> passedLocations) {
        findFinishInDirection(Direction.UP, location, passedLocations);
        findFinishInDirection(Direction.DOWN, location, passedLocations);
        findFinishInDirection(Direction.LEFT, location, passedLocations);
        findFinishInDirection(Direction.RIGHT, location, passedLocations);
    }

    private void findFinishInDirection(Direction direction, Location from, ArrayList<Location> passedLocations) {
        Location nextLocation = from.getLocationAtDirection(direction);
        if (canGoAtDirection(direction, from) && !passedLocations.contains(nextLocation)) {
            ArrayList<Location> copyOfPastLocations = (ArrayList<Location>) passedLocations.clone();
            copyOfPastLocations.add(nextLocation);
            findFinish(nextLocation, copyOfPastLocations);
        }
    }

    public boolean canGoAtDirection(Direction direction, Location from) {
        switch (direction) {
            case UP:
                return isWalkablePath(from.getX(), from.getY() - 1);
            case DOWN:
                return isWalkablePath(from.getX(), from.getY() + 1);
            case LEFT:
                return isWalkablePath(from.getX() - 1, from.getY());
            case RIGHT:
                return isWalkablePath(from.getX() + 1, from.getY());
            default:
                return isWalkablePath(from.getX(), from.getY() - 1);
        }
    }

    private void drawBestPathToMaze() {
        Location previous = bestFoundPath.remove(0);
        Location finish = bestFoundPath.remove(bestFoundPath.size() - 1);
        for (Location location : bestFoundPath) {
            setLocationAsWalkedPath(location);
            setAsWakedPathBetweenLocations(previous, location);
            previous = location;
        }
        setAsWakedPathBetweenLocations(previous, finish);
    }

    void setLocationAsWalkedPath(Location location) {
        setCoordinateAsWalked(location.getX(), location.getY());
    }

    void setAsWakedPathBetweenLocations(Location start, Location end) {
        if (start.getX() == end.getX()) {
            if (start.getY() < end.getY()) {
                setCoordinateAsWalked(start.getX(), start.getY() + 1);
            } else {
                setCoordinateAsWalked(start.getX(), start.getY() - 1);
            }
        } else {
            if (start.getX() < end.getX()) {
                setCoordinateAsWalked(start.getX() + 1, start.getY());
            } else {
                setCoordinateAsWalked(start.getX() - 1, start.getY());
            }
        }
    }

    private void setCoordinateAsWalked(int x, int y) {
        maze[x][y] = PATH_TO_FINISH;
    }

    public boolean isWalkablePath(int x, int y) {
        return maze[x][y] != WALL;
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
