/**
 * Purpose:
 * - This program is an Area & Volume Calculator that prompts the user for inputs
 *   and calculates:
 *   (1) Rectangle Area, (2) Sphere Volume, (3) Cylinder Volume, (4) Cube Volume.
 *
 * Requirements (Assignment Specs):
 * 1) Create a Java project and begin the Project Program by writing this multi-line
 *    comment at the top that describes the purpose and function of the program.
 * 2) Use object-oriented programming:
 *    - Create classes for shapes (e.g., Rectangle, Sphere, Cylinder, Cube).
 *    - Create appropriate method(s) to calculate area/volume for each shape.
 * 3) Console input/output:
 *    - Display a menu for the user to choose a calculation.
 *    - Prompt the user to enter required dimensions.
 * 4) Input validation:
 *    - All numeric inputs must be > 0 (reject 0/negative and non-numeric input).
 *    - Re-prompt until valid input is provided.
 * 5) Store results and show a summary (array output):
 *    - Store each completed calculation (type + dimensions + result).
 *    - When the user chooses "Show Summary and Exit", print all stored results.
 *
 * Notes:
 * - Use double for calculations.
 * - Use Math.PI for sphere/cylinder calculations.
 * - Format output to 4 decimal places where appropriate.
 */

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
         * Store calculation history using arrays (to satisfy "Implementing Arrays").
         * - labels[] keeps a readable description of each calculation (inputs included)
         * - results[] keeps the numeric result for that calculation
         * - count tracks how many calculations have been stored so far
         *
         * Note: The arrays are size 4, so the program can store up to 4 calculations.
         */
        String[] labels = new String[4];
        double[] results = new double[4];
        int count = 0;

        // Main program loop: show menu, handle user choice, repeat until user exits.
        while (true) {
            System.out.println("\n=== Area & Volume Calculator ===");
            System.out.println("1) Rectangle Area");
            System.out.println("2) Sphere Volume");
            System.out.println("3) Cylinder Volume");
            System.out.println("4) Cube Volume");
            System.out.println("5) Show Summary (array output) and Exit");
            System.out.print("Choose an option (1-5): ");

            // Read a valid menu choice from 1 to 5 (input validation).
            int choice = readInt(sc, 1, 5);

            // Option 5: Print summary and exit the program.
            if (choice == 5) {
                System.out.println("\n=== Summary ===");

                // If the user did not perform any calculation, show a message.
                if (count == 0) {
                    System.out.println("No calculations yet.");
                } else {
                    // Print all stored calculations from the arrays.
                    for (int i = 0; i < count; i++) {
                        System.out.printf("%d) %s = %.4f%n", (i + 1), labels[i], results[i]);
                    }
                }

                System.out.println("Bye!");
                break;
            }

            // Handle the selected calculation.
            switch (choice) {
                case 1: {
                    /*
                     * Rectangle Area:
                     * Use a small array to store user input values (also demonstrates arrays).
                     * dims[0] = length
                     * dims[1] = width
                     */
                    double[] dims = new double[2];

                    System.out.print("Enter length (>0): ");
                    dims[0] = readPositiveDouble(sc);

                    System.out.print("Enter width (>0): ");
                    dims[1] = readPositiveDouble(sc);

                    // Create a Rectangle object and compute area using its method.
                    Rectangle rect = new Rectangle(dims[0], dims[1]);
                    double area = rect.area();
                    System.out.printf("Rectangle area = %.4f%n", area);

                    // Store the calculation into arrays if there is still space.
                    if (count < results.length) {
                        labels[count] = "Rectangle area (L=" + dims[0] + ", W=" + dims[1] + ")";
                        results[count] = area;
                        count++;
                    }
                    break;
                }

                case 2: {
                    /*
                     * Sphere Volume:
                     * Prompt for radius, validate input, compute volume.
                     */
                    System.out.print("Enter radius (>0): ");
                    double r = readPositiveDouble(sc);

                    Sphere sphere = new Sphere(r);
                    double vol = sphere.volume();
                    System.out.printf("Sphere volume = %.4f%n", vol);

                    // Store the calculation into arrays if there is still space.
                    if (count < results.length) {
                        labels[count] = "Sphere volume (r=" + r + ")";
                        results[count] = vol;
                        count++;
                    }
                    break;
                }

                case 3: {
                    /*
                     * Cylinder Volume:
                     * Prompt for radius and height, validate input, compute volume.
                     */
                    System.out.print("Enter radius (>0): ");
                    double r = readPositiveDouble(sc);

                    System.out.print("Enter height (>0): ");
                    double h = readPositiveDouble(sc);

                    Cylinder cyl = new Cylinder(r, h);
                    double vol = cyl.volume();
                    System.out.printf("Cylinder volume = %.4f%n", vol);

                    // Store the calculation into arrays if there is still space.
                    if (count < results.length) {
                        labels[count] = "Cylinder volume (r=" + r + ", h=" + h + ")";
                        results[count] = vol;
                        count++;
                    }
                    break;
                }

                case 4: {
                    /*
                     * Cube Volume:
                     * Prompt for side length, validate input, compute volume.
                     */
                    System.out.print("Enter side length (>0): ");
                    double s = readPositiveDouble(sc);

                    Cube cube = new Cube(s);
                    double vol = cube.volume();
                    System.out.printf("Cube volume = %.4f%n", vol);

                    // Store the calculation into arrays if there is still space.
                    if (count < results.length) {
                        labels[count] = "Cube volume (side=" + s + ")";
                        results[count] = vol;
                        count++;
                    }
                    break;
                }
            }
        }

        // Close the Scanner to release system resources.
        sc.close();
    }

    /**
     * Reads an integer from the user within a specific range [min, max].
     * This method keeps prompting until the user enters a valid integer in range.
     *
     * @param sc  Scanner used to read input
     * @param min minimum allowed integer
     * @param max maximum allowed integer
     * @return a valid integer within [min, max]
     */
    private static int readInt(Scanner sc, int min, int max) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                int val = Integer.parseInt(line);
                if (val < min || val > max) {
                    System.out.print("Please enter a number between " + min + " and " + max + ": ");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.print("Invalid integer. Try again: ");
            }
        }
    }

    /**
     * Reads a positive double (> 0) from the user.
     * This method keeps prompting until the user enters a valid number greater than 0.
     *
     * @param sc Scanner used to read input
     * @return a positive double (> 0)
     */
    private static double readPositiveDouble(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                double val = Double.parseDouble(line);
                if (val <= 0) {
                    System.out.print("Value must be > 0. Try again: ");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }
}


