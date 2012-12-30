package maze;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public static Direction reverse(Direction direction) {
        switch (direction) {
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            default:
                return UP;
        }
    }
}
