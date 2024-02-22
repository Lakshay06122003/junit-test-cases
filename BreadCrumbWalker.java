
/**
 * The BreadCrumbWalker class is an extension of the RandomWalker class,
 * creating a bidirectional path by walking forward and then backward along the same path.
 */
import java.util.ArrayList;
import java.util.Collections;

public class BreadCrumbWalker extends RandomWalker {

    /**
     * Constructs a BreadCrumbWalker object with a given MarkovChain.
     *
     * @param chain The MarkovChain that defines the walker's random walk behavior.
     */
    public BreadCrumbWalker(MarkovChain chain) {
        super(chain);
    }

    /**
     * Overrides the walk method to create a bidirectional path.
     * Performs a random walk, generates a forward path, and appends its reverse to
     * form a bidirectional path.
     *
     * @param numSteps The number of steps to simulate in the bidirectional walk.
     * @return An ArrayList of Coordinate objects representing the bidirectional
     *         path.
     *         If numSteps is less than or equal to 0, returns an empty ArrayList.
     */
    @Override
    public ArrayList<Coordinate> walk(int numSteps) {
        if (numSteps <= 0) {
            return new ArrayList<>();
        }

        // Perform a random walk to create a forward path
        ArrayList<Coordinate> forwardPath = super.walk(numSteps);

        // Create a reverse path by reversing the forward path and append it to the
        // original path
        ArrayList<Coordinate> reversePath = new ArrayList<>(forwardPath);
        Collections.reverse(reversePath);
        forwardPath.addAll(reversePath.subList(1, reversePath.size()));

        return forwardPath;
    }
}
