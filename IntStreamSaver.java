import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Represents an implementation of the WalkSaver interface for saving a walk
 * path using IntStream format.
 */
public class IntStreamSaver implements WalkSaver {

    /**
     * Saves the walk path to the specified PrintWriter using IntStream format.
     *
     * @param path   The ArrayList of Coordinate objects representing the walk path.
     * @param writer The PrintWriter to write the walk path.
     */
    @Override
    public void saveWalkToFile(ArrayList<Coordinate> path, PrintWriter writer) {
        for (Coordinate coord : path) {
            writer.print(String.format("%d %d ", coord.x, coord.y));
        }
    }
}
