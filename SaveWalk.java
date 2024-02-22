import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Represents a SaveWalk class that manages the saving of a walk path to a file.
 */
public class SaveWalk {

    String fName;
    ArrayList<Coordinate> path;

    WalkSaver walkSaver;

    /**
     * Constructs a SaveWalk object with the specified file name and walk path.
     *
     * @param fName The file name to save the walk path.
     * @param path  The ArrayList of Coordinate objects representing the walk path.
     */
    SaveWalk(String fName, ArrayList<Coordinate> path) {
        this.fName = fName;
        this.path = path;
    }

    /**
     * Saves the walk path to the specified file based on the file name extension.
     *
     * @throws IOException If an I/O error occurs while saving the walk path.
     */
    public void saveWalkToFile() throws IOException {
        int length = fName.length();
        PrintWriter writer = new PrintWriter(fName);
        if (fName.charAt(length - 2) == 'a') {
            walkSaver = new IntStreamSaver();
            walkSaver.saveWalkToFile(path, writer);
            writer.close();
        } else {
            walkSaver = new OneCPerLineSaver();
            walkSaver.saveWalkToFile(path, writer);
            writer.close();
        }
    }
}
