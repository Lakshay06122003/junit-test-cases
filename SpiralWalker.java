import java.util.ArrayList;

/**
 * Implementation of the Walker interface representing a SpiralWalker.
 * A SpiralWalker generates a path by moving in a spiral pattern, with each step
 * extending
 * the distance from the center in a cyclic manner (East, South, West, North).
 */
public class SpiralWalker implements Walker {

    private int currentStep;
    private ArrayList<Coordinate> path;
    private int x;
    private int y;

    /**
     * Constructs a new SpiralWalker.
     */
    public SpiralWalker() {
        currentStep = 0;
        path = new ArrayList<>();
        x = 0;
        y = 0;
    }

    /**
     * Generates a path by performing a spiral walk for the given number of steps.
     *
     * @param numSteps The number of steps for the spiral walk.
     * @return An ArrayList of Coordinate objects representing the generated path.
     */
    @Override
    public ArrayList<Coordinate> walk(int numSteps) {
        path.clear(); // reset the path for this new walk.

        x = 0;
        y = 0;

        for (int step = 0; step < numSteps; ++step) {
            path.add(new Coordinate(x, y));
            updateCoordinates();
        }

        return path;
    }

    /**
     * Updates the walker's coordinates based on the current step in the spiral
     * pattern.
     * The walker moves cyclically in the directions East, South, West, North.
     */
    private void updateCoordinates() {
        int cycle = currentStep / 4;
        int remainder = currentStep % 4;
        double angle = cycle * Math.PI / 2.0;
        int radius = cycle;

        switch (remainder) {
            case 0: // East
                x = (int) Math.round(radius * Math.cos(angle));
                y = (int) Math.round(radius * Math.sin(angle));
                break;
            case 1: // South
                x = (int) Math.round(radius * Math.cos(angle + Math.PI / 2.0));
                y = (int) Math.round(radius * Math.sin(angle + Math.PI / 2.0));
                break;
            case 2: // West
                x = (int) Math.round(radius * Math.cos(angle + Math.PI));
                y = (int) Math.round(radius * Math.sin(angle + Math.PI));
                break;
            case 3: // North
                x = (int) Math.round(radius * Math.cos(angle + 3 * Math.PI / 2.0));
                y = (int) Math.round(radius * Math.sin(angle + 3 * Math.PI / 2.0));
                break;
        }

        currentStep++;
    }
}
