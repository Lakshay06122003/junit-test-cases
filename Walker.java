
/**
 * The Walker interface represents an entity that can perform a random walk on a lattice.
 * It defines the basic properties and behavior of a walker in a 2D coordinate system.
 */

import java.io.IOException;
import java.util.ArrayList;

public interface Walker {

    int START_X = 0;
    int START_Y = 0;
    int STEP_SIZE = 1;

    /**
     * Performs a random walk for a specified number of steps and returns the
     * resulting path.
     *
     * @param numSteps The number of steps to simulate in the random walk.
     * @return An ArrayList of Coordinate objects representing the path of the walk.
     */
    ArrayList<Coordinate> walk(int numSteps);
}
