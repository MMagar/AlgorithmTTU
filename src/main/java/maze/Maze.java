package maze;

import java.util.ArrayList;

public class Maze {
    public static final char WALKED_PATH_CHARACTER = '*';
    private Location beginning;
    private Location finish;
    private char[][] maze;
    private int dimension;
    ArrayList<Location> bestFoundPath;

    public char[][] solve(char[][] maze) {
        this.maze = maze;
        findBeginningAndFinishLocation();
        bestFoundPath = findShortestPathFromBeginningToFinish();
        drawBestFoundPathToMaze();
        return maze;
    }

    private void drawBestFoundPathToMaze() {
        Location previous = bestFoundPath.remove(0);
        Location finish = bestFoundPath.remove(bestFoundPath.size()-1);
        for (Location location : bestFoundPath) {
            setValueAtLocation(location, WALKED_PATH_CHARACTER);
            setValueBetweenLocations(previous, location, WALKED_PATH_CHARACTER);
            previous = location;
        }
        setValueBetweenLocations(previous, finish, WALKED_PATH_CHARACTER);
    }

    void findBeginningAndFinishLocation() {
        char character;
        beginning = null;
        finish = null;
        for (int column = 0; column < dimension; column++) {
            for (int row = 0; row < dimension; row++) {
                character = getValueAtLocation(column, row);
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

    char getValueAtLocation(int column, int row) {
        return maze[column * 2 + 1][row * 2 + 1];
    }

    void setValueBetweenLocations(Location start, Location end, char newValue) {
        if(start.getX() == end.getX()) {
            if(start.getY() < end.getY()) {
                maze[start.getX()][start.getY()+1] = newValue;
            } else {
                maze[start.getX()][start.getY()-1] = newValue;
            }
        } else {
            if(start.getX() < end.getX()) {
                maze[start.getX()+1][start.getY()] = newValue;
            } else {
                maze[start.getX()-1][start.getY()] = newValue;
            }
        }
    }

    void setValueAtLocation(Location location, char newValue) {
        maze[location.getX()][location.getY()] = newValue;
    }

    private ArrayList<Location> findShortestPathFromBeginningToFinish() {
        ArrayList<Location> path = new ArrayList<Location>();
        path.add(beginning);
        return findFinish(beginning, path);
    }

    private ArrayList<Location> findFinish(Location location, ArrayList<Location> passedLocations) {
        if (isFinish(location)) {
            return passedLocations;
        }
        return findFinishByLookingAtAllDirections(location, passedLocations);
    }

    private boolean isFinish(Location location) {
        return finish.equals(location);
    }

    private ArrayList<Location> findFinishByLookingAtAllDirections(Location location, ArrayList<Location> passedLocations) {
        ArrayList<Location> upPath = findFinishInDirection(Direction.UP, location, passedLocations);
        ArrayList<Location> downPath = findFinishInDirection(Direction.DOWN, location, passedLocations);
        ArrayList<Location> leftPath = findFinishInDirection(Direction.LEFT, location, passedLocations);
        ArrayList<Location> rightPath = findFinishInDirection(Direction.RIGHT, location, passedLocations);
        return pickShortestPath(upPath, downPath, leftPath, rightPath);
    }

    private ArrayList<Location> findFinishInDirection(Direction direction, Location from, ArrayList<Location> passedLocations) {
        Location nextLocation = from.getLocationAtDirection(direction);
        if (canGoAtDirection(direction, from) && !passedLocations.contains(nextLocation)) {
            ArrayList<Location> copyOfPastLocations = (ArrayList<Location>) passedLocations.clone();
            copyOfPastLocations.add(nextLocation);
            return findFinish(nextLocation, copyOfPastLocations);
        }
        return null;
    }

    ArrayList<Location> pickShortestPath(ArrayList<Location>... paths) {
        ArrayList<Location> bestPath = paths[0];
        for (int i = 1; i < paths.length; i++) {
            bestPath = pickShorterPathOfTwo(bestPath, paths[i]);
        }
        return bestPath;
    }

    private ArrayList<Location> pickShorterPathOfTwo(ArrayList<Location> firstPath, ArrayList<Location> secondPath) {
        if(firstPath == null)
            return secondPath;
        else if(secondPath == null)
            return firstPath;
        else
            return firstPath.size() > secondPath.size() ? secondPath : firstPath;
    }

    public boolean canGoAtDirection(Direction direction, Location from) {
        switch (direction) {
            case UP:
                return maze[from.getX()][from.getY() - 1] == ' ';
            case DOWN:
                return maze[from.getX()][from.getY() + 1] == ' ';
            case LEFT:
                return maze[from.getX() - 1][from.getY()] == ' ';
            case RIGHT:
                return maze[from.getX() + 1][from.getY()] == ' ';
            default:
                return maze[from.getX()][from.getY() - 1] == ' ';
        }
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
