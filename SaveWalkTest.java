import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the SaveWalk class.
 */
public class SaveWalkTest {

    /**
     * Test for the saveWalkToFile method with the "oneCPerLine" strategy.
     * Verifies that the file is created and contains coordinates on separate lines.
     *
     * @throws IOException if an I/O error occurs during the test
     */
    @Test
    void saveWalkToFile_oneCPerLine() throws IOException {
        String fileName = "test_oneCPerLine.txt";
        ArrayList<Coordinate> path = new ArrayList<>();
        path.add(new Coordinate(0, 0));
        path.add(new Coordinate(1, 1));
        path.add(new Coordinate(2, 2));

        SaveWalk saveWalk = new SaveWalk(fileName, path);
        saveWalk.saveWalkToFile();

        File file = new File(fileName);
        assertTrue(file.exists());

        Scanner scanner = new Scanner(file);
        assertEquals("(0, 0)", scanner.nextLine().trim());
        assertEquals("(1, 1)", scanner.nextLine().trim());
        assertEquals("(2, 2)", scanner.nextLine().trim());

        scanner.close();
        file.delete(); // Clean up
    }

    /**
     * Test for the saveWalkToFile method with the "intStream" strategy.
     * Verifies that the file is created and contains coordinates in a
     * space-separated format.
     *
     * @throws IOException if an I/O error occurs during the test
     */
    @Test
    void saveWalkToFile_intStream() throws IOException {
        String fileName = "test_intStream.dat";
        ArrayList<Coordinate> path = new ArrayList<>();
        path.add(new Coordinate(0, 0));
        path.add(new Coordinate(1, 1));
        path.add(new Coordinate(2, 2));

        SaveWalk saveWalk = new SaveWalk(fileName, path);
        saveWalk.saveWalkToFile();

        File file = new File(fileName);
        assertTrue(file.exists());

        Scanner scanner = new Scanner(file);
        assertEquals("0 0 1 1 2 2", scanner.nextLine().trim());

        scanner.close();
        file.delete(); // Clean up
    }
}
