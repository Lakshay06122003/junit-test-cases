import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WalkSim {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);

        int nSteps = promptSteps(reader, "Enter a positive number of steps to walk: ");
        int walkerType = promptWalker(reader);
        System.out.print("Enter the input file Name: ");
        String inputFile = scanner.nextLine();
        System.out.print("Enter the output file Name(.txt or .dat): ");
        String outputFile = scanner.nextLine();

        String[] cardinals = { "N", "E", "S", "W" };
        FloatMatrix T1 = null;
        Walker walker;
        ArrayList<Coordinate> theWalk;
        // int stepDuration = 30;

        try {
            T1 = FloatMatrix.fromFile(inputFile);
            assert T1.rows() == 4 : "Walker MarkovChain should have 4 states";
            System.out.println(T1.prettyString());
            MarkovChain mc = new MarkovChain(T1, cardinals);
            if (walkerType == 0) {
                walker = new RandomWalker(mc);
                theWalk = walker.walk(nSteps);
            } else if (walkerType == 1) {
                walker = new SpiralWalker();
                theWalk = walker.walk(nSteps);
            } else {
                walker = new BreadCrumbWalker(mc);
                theWalk = walker.walk(nSteps);
            }

            SaveWalk output = new SaveWalk(outputFile, theWalk);
            output.saveWalkToFile();

        } catch (FileNotFoundException fnfe) {
            System.out.println("Could not find the specified matrix file.");
            System.out.println(fnfe.toString());
            System.exit(1);
        } catch (IOException e) {

        }

    }

    private static int promptSteps(BufferedReader reader, String prompt) {
        int result = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                String input = reader.readLine();
                result = Integer.parseInt(input);

                if (result > 0) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a positive integer.");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
            }
        }
        return result;
    }

    private static int promptWalker(BufferedReader reader) {
        int result = 0;
        boolean validInput = false;

        while (!validInput) {
            try {

                System.out.print("Enter walker type (0 for Random walk, 1 for Spiral walk, 2 for Bread crumb walk): ");
                String input = reader.readLine();
                result = Integer.parseInt(input);

                if (result >= 0 && result <= 2) {
                    validInput = true;
                } else {
                    System.out.println("Please enter 0, 1, or 2.");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Invalid input. Please enter 0, 1, or 2.");
            }
        }
        return result;
    }
}
