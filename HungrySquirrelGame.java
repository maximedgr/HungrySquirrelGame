/**
 *
 * @author Maxime D.
 * Final Project - JAVA I - UCLA
 */
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.util.InputMismatchException;

public class HungrySquirrelGame {
    public static boolean status;
    
    /**
    * Method. Create random nuts (Almond, Peanuts)
    **/
    public static void createNuts() {
        Random random = new Random();
        for (int i = 0; i < Nut.TOTAL_NUTS; i++) {
            Nut nut;
            if (random.nextBoolean()) {
                nut = new Almond(); // 50% chance
            } else {
                nut = new Peanut(); // 50% chance
            }
            nut.create(); // Randomly place the nut
        }
    }
    
    /**
    * Method. Create random Poisonous Nuts
    **/
    public static void createPoisonousNuts() {
        for (int i = 0; i < Nut.TOTAL_POISONOUS_NUTS; i++) {
            Nut nut = new PoisonousCashew();
            nut.create(); // Randomly place the poisonous cashew
        }
    }
    
    /**
    * Method. Print an ASCII Squirrel
    **/
    public static void printThatSquirrel(){
        System.out.println("          )\" .");
        System.out.println("         /    \\      (\\-./");
        System.out.println("        /     |    _/ o. \\");
        System.out.println("       |      | .-\"      y)-");
        System.out.println("       |      |/       _/ \\");
        System.out.println("       \\     /j   _\".\\(@) ");
        System.out.println("        \\   ( |    `.''  )");
        System.out.println("         \\  _`-     |   /");
        System.out.println("           \"  `-._  <_ (");
        System.out.println("                  `-.,),)");
    }
    
    /**
    * Method. Print Game Board
    **/
    public static void printGameBoard(int point_collected, int nutleft){
        //System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("################## INFO #####################");
        System.out.println("Points collected : "+point_collected);
        System.out.println("Nuts left : "+nutleft);
        System.out.println("#############################################");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        status=false;
        //1. Generate the maze
        Scanner scanner = new Scanner(System.in);
        Maze maze;
        
        System.out.println("###### WELCOME TO THE HUNGY SQUIRREL GAME ######");
        printThatSquirrel();

        while (true) {
            try {
                // 1. Prompt for Maze File Name
                System.out.print("Enter the name of the file for the maze: ");
                String mazeFileName = scanner.nextLine();

                File file = new File(mazeFileName);
                if (!file.exists()) {
                    throw new Exception("File not found. Please try again.");
                }

                // Create Maze using the provided file name
                maze = new Maze(mazeFileName);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        maze.display();
        
        // 2. Create Squirrel
        Squirrel squirrel = new Squirrel();
        squirrel.create();

        // 3. Create Nuts
        createNuts();
        createPoisonousNuts(); //Bonus
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        printGameBoard(squirrel.getPointsCollected(),Nut.TOTAL_NUTS-squirrel.totalNutsEaten);
        maze.display();
        // Game Loop
        while (!status) {
            try {
                // 4. Accept user input
                System.out.println("######-> Enter a move (U/D/L/R) and ENTER: ");
                char move = scanner.next().charAt(0);
                squirrel.move(move);

                // 5 & 6. Display Maze and Points
                printGameBoard(squirrel.getPointsCollected(), Nut.TOTAL_NUTS - squirrel.totalNutsEaten);
                maze.display();

                // Check if squirrel eats a nut and update points

                // 8. Check if all nuts are collected
                if ((squirrel.totalNutsEaten == Nut.TOTAL_NUTS)) {
                    
                    System.out.println("\n-> Squirrel successfully collected all the nuts. Total points " + squirrel.getPointsCollected());
                    System.out.println("Thank you for playing this game");
                    printThatSquirrel();
                    status = true;
                    break;
                }
                if(squirrel.getPointsCollected()<0){
                    
                    System.out.println("\n-> Squirrel DIED !! Score : " + squirrel.getPointsCollected());
                    System.out.println("Thank you for playing this game");
                    printThatSquirrel();
                    status = true;
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid move (U/D/L/R).");
                scanner.nextLine(); // Consume the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                // Optional: Decide whether to break the loop or continue
            }
        }
        scanner.close();
    }
    
}
