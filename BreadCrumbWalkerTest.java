import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the BreadCrumbWalker class.
 */
public class BreadCrumbWalkerTest {

    /**
     * Test for the walk method with a positive number of steps.
     * Verifies that the length of the path is as expected (2N-1 steps).
     */
    @Test
    void walk_testCommon() {
        float[] testMat = { 0.25f, 0.25f, 0.25f, 0.25f,
                0.25f, 0.25f, 0.25f, 0.25f,
                0.25f, 0.25f, 0.25f, 0.25f,
                0.25f, 0.25f, 0.25f, 0.25f };
        MarkovChain testMC = new MarkovChain(new FloatMatrix(testMat, 4));
        BreadCrumbWalker walker = new BreadCrumbWalker(testMC);
        int Nsteps = 5;

        ArrayList<Coordinate> path = walker.walk(Nsteps);

        assertNotNull(path);
        assertEquals(path.size(), 11, "Expected 2N-1 steps on the path");
    }

    /**
     * Test for the walk method with zero steps.
     * Verifies that an empty path is returned.
     */
    @Test
    void walk_testZeroSteps() {
        float[] testMat = { 0.25f, 0.25f, 0.25f, 0.25f,
                0.25f, 0.25f, 0.25f, 0.25f,
                0.25f, 0.25f, 0.25f, 0.25f,
                0.25f, 0.25f, 0.25f, 0.25f };
        MarkovChain testMC = new MarkovChain(new FloatMatrix(testMat, 4));
        BreadCrumbWalker walker = new BreadCrumbWalker(testMC);
        int Nsteps = 0;

        ArrayList<Coordinate> path = walker.walk(Nsteps);

        assertNotNull(path);
        assertEquals(path.size(), 0, "Expected empty path with 0 steps.");
    }

    /**
     * Test for the walk method with negative steps.
     * Verifies that an empty path is returned.
     */
    @Test
    void walk_testNegSteps() {
        float[] testMat = { 0.25f, 0.25f, 0.25f, 0.25f,
                0.25f, 0.25f, 0.25f, 0.25f,
                0.25f, 0.25f, 0.25f, 0.25f,
                0.25f, 0.25f, 0.25f, 0.25f };
        MarkovChain testMC = new MarkovChain(new FloatMatrix(testMat, 4));
        BreadCrumbWalker walker = new BreadCrumbWalker(testMC);
        int Nsteps = -1;

        ArrayList<Coordinate> path = walker.walk(Nsteps);

        assertNotNull(path);
        assertEquals(path.size(), 0, "Expected empty path with negative steps.");
    }
}
