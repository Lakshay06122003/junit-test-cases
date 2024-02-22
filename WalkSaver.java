import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Interface representing a WalkSaver, responsible for saving a walk path to a
 * file.
 */
public interface WalkSaver {

    /**
     * Saves the given walk path to the specified PrintWriter.
     *
     * @param path   The ArrayList of Coordinate objects representing the walk path.
     * @param writer The PrintWriter used to write the walk path to a file.
     * @throws IOException If an I/O error occurs while saving the walk path.
     */
    void saveWalkToFile(ArrayList<Coordinate> path, PrintWriter writer) throws IOException;
}
