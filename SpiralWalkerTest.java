import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the SpiralWalker class.
 */
public class SpiralWalkerTest {

    /**
     * Test for the walk method with a common case.
     * Verifies that the path size is equal to the number of steps.
     */
    @Test
    void walk_testCommon() {
        SpiralWalker walker = new SpiralWalker();
        int Nsteps = 10;

        ArrayList<Coordinate> path = walker.walk(Nsteps);

        assertNotNull(path);
        assertEquals(path.size(), Nsteps, "Expected N steps on the path");
    }

    /**
     * Test for the walk method with zero steps.
     * Verifies that the path is empty.
     */
    @Test
    void walk_testZeroSteps() {
        SpiralWalker walker = new SpiralWalker();
        int Nsteps = 0;

        ArrayList<Coordinate> path = walker.walk(Nsteps);

        assertNotNull(path);
        assertEquals(path.size(), 0, "Expected empty path with 0 steps.");
    }

    /**
     * Test for the walk method with negative steps.
     * Verifies that the path is empty.
     */
    @Test
    void walk_testNegSteps() {
        SpiralWalker walker = new SpiralWalker();
        int Nsteps = -1;

        ArrayList<Coordinate> path = walker.walk(Nsteps);

        assertNotNull(path);
        assertEquals(path.size(), 0, "Expected empty path with negative steps.");
    }

    /**
     * Test for the walk method with a large number of steps.
     * Verifies that the path size is equal to the number of steps.
     */
    @Test
    void walk_testLargeSteps() {
        SpiralWalker walker = new SpiralWalker();
        int Nsteps = 1000;

        ArrayList<Coordinate> path = walker.walk(Nsteps);

        assertNotNull(path);
        assertEquals(path.size(), Nsteps, "Expected N steps on the path");
    }
}
