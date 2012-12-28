package maze;

public class Location {
    int column;
    int row;

    public Location(int column, int row) {
        this.column = column;
        this.row = row;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Location) {
            Location other = (Location) obj;
            return column == other.column && row == other.row;
        }
        return false;
    }
}
